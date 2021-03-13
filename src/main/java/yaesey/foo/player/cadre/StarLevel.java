package yaesey.foo.player.cadre;

import net.minecraft.text.TranslatableText;

import java.lang.reflect.Field;

/**
 * 两星、六星等等
 */
public enum StarLevel {
    TWO_STAR(2, 0, 2),
    THREE_STAR(3, 1, 2),
    FOUR_STAR(4, 2, 2),
    FIVE_STAR(5, 2, 2),
    SIX_STAR(6, 3, 2);
    final int starCount;
    final int skillCount;
    final int buildCount;

    StarLevel(int starCount, int skillCount, int buildCount) {
        this.starCount = starCount;
        this.skillCount = skillCount;
        this.buildCount = buildCount;
    }

    public StarLevel find(int level) {
        if (level < 2 || level > 6) {
            return null;
        } else {
            for (Field field : StarLevel.class.getDeclaredFields()) {
                try {
                    StarLevel starLevel = (StarLevel) field.get(null);
                    if (level == starLevel.starCount) {
                        return starLevel;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    public TranslatableText getTranslatableText() {
        return new TranslatableText("star.level." + this.starCount);
    }

    public int getStarCount() {
        return starCount;
    }

    /**
     * @return 战斗技能数
     */
    public int getSkillCount() {
        return skillCount;
    }

    /**
     * @return 基建技能数
     */
    public int getBuildCount() {
        return buildCount;
    }
}
