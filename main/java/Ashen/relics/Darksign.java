package Ashen.relics;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.helpers.ImageMaster;

public class Darksign extends CustomRelic {

    public static final String ID = "Darksign";
    public static final String IMG = "images/relics/Darksign.png";

    public Darksign(){
        super(ID, ImageMaster.loadImage(IMG), RelicTier.STARTER, LandingSound.MAGICAL);
    }
}
