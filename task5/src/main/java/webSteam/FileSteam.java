package webSteam;

import webSteam.elements.Button;

public class FileSteam {

    public static void download () {
        Button downloadSteam = new Button(PartsOfMenu.install1Button);
        Button.click(downloadSteam);
        Button downloadSteam2 = new Button(PartsOfMenu.install2Button);
        Button.click(downloadSteam2);
    }

}
