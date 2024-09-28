package Task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class ProductScrap {
    public static void main(String[] args) {
        try {
            // URL of the e-commerce site
            String url="https://www.amazon.in/b/ref=AF_WIN_bub_w_cml_t_4?pf_rd_r=4B17YNCMGWEWB7DZVPMC&pf_rd_p=bf54bb65-cdcf-455a-91d9-37e66a892305&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_s=merchandised-search-6&pf_rd_t=&pf_rd_i=97656053031&ie=UTF8&node=98055243031&ref_=smartchoice_multitasking";

            Document doc=Jsoup.connect(url).get();
            Elements carousel=doc.select(".a-carousel-viewport");  
            // Create a CSV file to store product information
            FileWriter csv = new FileWriter("products.csv");
            csv.append("Product Name,Price,Rating\n");
            //Traversing the product carousel to get one product after another
            //and getting name, price, raing of each.
            for(Element card : carousel.select("li.a-carousel-card")) {
                String name=card.select("span.a-truncate-cut").text();          
                String price=card.select("span.a-price-symbol").text() +
                             card.select("span.a-price-whole").text() +
                             card.select("span.a-price-fraction").text();
                Elements stars=card.select("i.a-icon-star-medium");
                int starCount=stars.size();
                String rating=String.valueOf(starCount);
                //appending to the csv file
                csv.append(name+","+price+","+rating+"\n");
            }
            csv.close();
            System.out.println("Data stored to products.csv");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
