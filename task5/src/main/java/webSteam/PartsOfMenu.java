package webSteam;

public class PartsOfMenu extends Menu{

    public static String game = combine(menuXPath,"genre_tab");
    public static String ekshenRus = "//div[@id=\"genre_flyout\"]/div/a[16]";
    public static String ekshenEn = "//div[@id=\"genre_flyout\"]/div/a[7]";

    public static String topSellersRus = "//*[@id=\"tab_select_TopSellers\"]";
    public static String saleListXPath = "//div[@id=\"TopSellersRows\"]//div[@class = \"discount_pct\"]";
    public static String baseSaleListXPath = "//div[@id=\"TopSellersRows\"]//div[@class = \"bundle_base_discount\"]";
    public static String saleInGameXPath = "//div[@class=\"game_purchase_action\"]//div[@class=\"discount_pct\"]";
    public static String baseSaleInGamestXPath = "//div[@class=\"game_purchase_action\"]//div[@class=\"bundle_base_discount\"]";

    public static String pageAgeId = "app_agegate";
    public static String pageAgeYearXPath = "//*[@id=\"ageYear\"]";
    public static String pageAgeCloseRus = "Открыть страницу";
    public static String pageAgeCloseEn = "View Page";

    public static String install1Button = "//*[@id=\"global_action_menu\"]/div[1]/a";
    public static String install2Button = "//*[@id=\"about_install_steam_link\"]";

    public static String combine (String firstPart, String secondPart){
        return String.format(firstPart,secondPart);
    }




}
