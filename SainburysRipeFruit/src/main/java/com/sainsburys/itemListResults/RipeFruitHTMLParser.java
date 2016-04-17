package com.sainsburys.itemListResults;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RipeFruitHTMLParser {
	
	public static void main(String[] args){
		Document doc;
		try {
			doc = Jsoup.connect("http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?msg=&langId=44&categoryId=185749&storeId=10151&krypto=D5cr1dc7Vwu0JtadVrnjiDZan%2FySmEcXybwdiVb4O1MAsbYzQkqEIYwfYL7cZn89aTH2J%2FaGnA%2B%2BPX20QgW9%2FjhVH8J%2F3zzS5lYBt0e3qPbpvJM7c63Hh9WRtQ334eIKYb%2FHWLcZBYkYEX2b6RkoLJwqdfg8kz291FGg7axAOvxGB1dtzV%2F0Gqe0ajEGm1rxZ6nFFQSStDD8SmDxpmUtbJxYRyiiWaK7iYo2oSOGi%2FpjnhAw8O09HJWU2MYnYcvi9eHCXrdbqdz2StU1vzR%2Fgkr7OinbnVTRhzSeSS4DicE%3D#langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true")
					.get();
			Element itemList = doc.getElementById("productLister");
			Elements items = itemList.getElementsByTag("li");
			for (Element item : items){
				String title = item.getElementsByClass("productDesciptionContainer").text();
				String unitPriceStr = item.getElementsByClass("pricePerUnit").text();
				String description = item.getElementsByClass("productText").first().text();
				System.out.println(title+unitPriceStr+description);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
