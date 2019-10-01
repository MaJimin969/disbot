package listener;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import domain.LunchVO;

public class Parser {
	public LunchVO getMenu(String date) {
		String url = "http://www.y-y.hs.kr/lunch.view?date=" + date;
		LunchVO lunch = new LunchVO();
		
		//여기에 점심을 가져오는 코드를 작성합시다.
		try {
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc.html());
			
			String menu = doc.selectFirst(".menuName > span").text();
			
			lunch.setMenuString(menu);
		} catch (IOException e) {
			lunch.setMenuString("메뉴 없음");
		}
		return lunch;
	}
}
