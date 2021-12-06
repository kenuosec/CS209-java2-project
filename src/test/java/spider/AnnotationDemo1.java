package spider;


import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.example.OschinaBlog;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

import java.util.List;

@TargetUrl("http://my.oschina.net/flashsword/blog/\\d+")
public class AnnotationDemo1 {

    @ExtractBy("//title")
    private String title;

    @ExtractBy(value = "div.BlogContent",type = ExtractBy.Type.Css)
    private String content;

    @ExtractBy(value = "//div[@class='BlogTags']/a/text()", multi = true)
    private List<String> tags;

    public static void main(String[] args) {
//
//        OOSpider.create(
//                Site.me(),
//                new ConsolePageModelPipeline(), OschinaBlog.class)
        OOSpider.create(
                Site.me(),
                new ConsolePageModelPipeline(), AnnotationDemo1.class)
                .addUrl("http://my.oschina.net/flashsword/blog")
                .addPipeline((a,b)-> System.out.println(a))
                .addPipeline(new JsonFilePipeline("E:\\java_code\\idea\\CS209-java2-project\\spider_data/"))
                .run();

    }
}
