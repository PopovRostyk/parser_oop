public class ParseCategory extends ParseCategoryPage {
    public ParseCategory(String url) throws Exception {
    super(url);
}


    public void parse_category() throws Exception {
        int num = Integer.parseInt(this.doc.getElementsByClass("novisited paginator-catalog-l-link").last().text());
        for (int i = 0; i < num; i++) {
            parse_category_page(url + "page=" + i + "/");
        }
    }
}