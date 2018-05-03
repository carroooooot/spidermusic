package com.minxuan.webcrawler.processor;

import com.minxuan.webcrawler.downloader.MyHttpClientDownloader;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author wdtc
 */
public class MyGithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setCharset("utf-8").setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new MyGithubRepoPageProcessor()).addPipeline(new JsonFilePipeline("F://test")).setDownloader(new MyHttpClientDownloader()) .addUrl("https://github.com/code4craft").thread(5).run();

    }

}
