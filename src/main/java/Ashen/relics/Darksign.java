package Ashen.relics;

import basemod.abstracts.CustomRelic;
import com.evacipated.cardcrawl.mod.stslib.relics.OnPlayerDeathRelic;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.relics.AbstractRelic;


public class Darksign extends CustomRelic implements OnPlayerDeathRelic {

    public static final String ID = "Darksign";
    public static final String IMG = "images/relics/Darksign.png";

    public Darksign(){
        super(ID, IMG, RelicTier.STARTER, LandingSound.MAGICAL);
    }

    @Override
    public boolean onPlayerDeath(AbstractPlayer plr, DamageInfo dmgInfo) {

        plr.decreaseMaxHealth(plr.maxHealth/2);
        plr.heal(plr.maxHealth);

        plr.loseGold(plr.gold);

        plr.relics.remove(this);
        plr.relics.add(new Hollow());

        return true;
    }

    @Override
    public AbstractRelic makeCopy(){
        return new Darksign();
    }
}
