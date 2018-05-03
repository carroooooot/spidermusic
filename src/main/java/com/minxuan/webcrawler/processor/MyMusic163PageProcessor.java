package com.minxuan.webcrawler.processor;

import com.minxuan.webcrawler.downloader.MyHttpClientDownloader;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class MyMusic163PageProcessor implements PageProcessor{

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        List<String> urlList = page.getHtml().css("div.m-sgerlist").links().regex(".*/artist\\?id=.*").all();
        page.addTargetRequests(urlList);
        page.putField("name", page.getHtml().xpath("//a[@class='nm nm-icn f-thide s-fc0']").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {
        Spider.create(new MyMusic163PageProcessor()).addPipeline(new JsonFilePipeline("F://test")).setDownloader(new MyHttpClientDownloader()) .addUrl("https://music.163.com/discover/artist/cat?id=1001&initial=65").thread(5).run();
    }
}
