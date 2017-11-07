import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ParseReviewsPage {
    Document doc;
    String url;

    public ParseReviewsPage(String url) throws IOException {
        this.url = url;
        this.doc = Jsoup.connect(url).get();
    }

    public Document getDoc() {
        return doc;
    }

    public List<Elements> parse_reviews_page(String url) throws IOException {


        Elements reviews = doc.getElementsByClass("pp-review-i").select("article");
        List stars_coms = new ArrayList();
        for (Element review : reviews
                ) {

            String star = review.getElementsByClass("g-rating-stars-i").select("span").attr("content");
            Elements comments = review.getElementsByClass("pp-review-text").select("div");
            stars_coms.add(star);
            stars_coms.add(comments.first().getElementsByClass("pp-review-text-i").text());
        }
        return stars_coms;
    }
}
