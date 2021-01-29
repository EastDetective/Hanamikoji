public class PttMessages {
  
  public static void main(String[] args) throws InterruptedException {
    
    String messages[] = {
        "→ bluewinds:我在香港迪士尼有遇到邱淑貞 和她坐同艘船~搞到最後 我   11/02 21:11",
        "推 FackPtt:  就射出來了                                                                              11/02 21:12",
        "→ bluewinds:們都在看她 沒有人聽解說人員講話~~她本人人超好~~一聽  11/02 21:12",
        "推 ZBeta:    就射出來了                                                                              11/02 21:13",
        "→ bluewinds:到我們是台灣來的 就很開心的和我們合照~~後來去廁所又  11/02 21:12",
        "→ sephen:   射出來了                                                                                  11/02 21:13"
    };
    
    for (int i = 0;i < messages.length;i++) {
      System.out.println(messages[i]);
      Thread.sleep(3000); // 暫停3秒
    }
    
  }
}