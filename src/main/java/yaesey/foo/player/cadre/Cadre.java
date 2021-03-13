package yaesey.foo.player.cadre;


import net.minecraft.text.TranslatableText;

/**
 * todo:说起来你们可能不信，我们打算重写所有会跑会跳生物的属性，给他们生命值、物理防御和法术抗性,相应的每个职业都将会有自己的初始值
 */
public class Cadre {
    private final String cadreName;
    private StarLevel level;

    private int startSkill = 0;
    private int startBuildSkill = 0;

    public Cadre(String cadreName,StarLevel level) {
        this.cadreName = cadreName;
        this.level = level;
    }

    public boolean upgradeStar() {
        if (level.getStarCount() > 6) {
            return false;
        } else {
            int newStarCount = level.starCount + 1;
            this.level = level.find(newStarCount);
            return true;
        }
    }

    public boolean upgradeSkill() {
        if (startSkill >= level.skillCount) {
            return false;
        } else {
            startSkill += 1;
            return true;
        }
    }

    public boolean upgradeBuildSkill() {
        if (startBuildSkill >= level.buildCount) {
            return false;
        } else {
            startBuildSkill += 1;
            return true;
        }
    }

    public TranslatableText getTranslatableText() {
        return new TranslatableText("cadre." + this.cadreName);
    }
}