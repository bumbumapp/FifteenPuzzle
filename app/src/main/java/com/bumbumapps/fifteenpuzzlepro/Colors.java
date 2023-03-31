package com.bumbumapps.fifteenpuzzlepro;

public class Colors {

    private static final int MUTED_BLUE = 0xff221f35;
    private static final int MUTED_BLUE_U = 0xff454c51;

    private static final int RED = 0xff983030;
    private static final int RED_U = 0xff5b3434;

    private static final int ORANGE = 0xffd2974c;
    private static final int ORANGE_U = 0xff705a3f;

    private static final int GREEN = 0xff39885a;
    private static final int GREEN_U = 0xff385544;

    private static final int PURPLE = 0xff614d69;
    private static final int PURPLE_U = 0xff47404a;

    private static final int BLUE = 0xff5893b5;
    private static final int BLUE_U = 0xff435965;

    private static final int GREY = 0xff838383;
    private static final int GREY_U = 0xff535353;

    private static final int PINK = 0xff935783;
    private static final int PINK_U = 0xff594353;

    private static final int LIGHT_GREEN = 0xff8db368;
    private static final int LIGHT_GREEN_U = 0xff576549;

    private static final int BLACK = 0xff111111;
    private static final int BLACK_U = 0xff373553;

    private static final int WHITE = 0xffeeeeee;
    private static final int WHITE_U = 0xff7a7a7a;

    private static final int CYAN = 0xff3fa694;
    private static final int CYAN_U = 0xff4e6e68;

    public static final int backgroundField = 0xff28273A;
    public static final int menuTextValue = 0xfffefefe;
    private static final int[] background = {0xff373553, 0xff181818};
    private static final int[] overlay = {0xff28273A, 0xff28273A};
    private static final int[] overlayText = {0xffFFC107, 0xffFFC107};
    private static final int[] spriteText = {0xffffffff, 0xffffffff};
    private static final int[] textInfo = {0xffFFC107, 0xffFFC107};
    private static final int[] tilesDay = {
            MUTED_BLUE,
            RED,
            ORANGE,
            CYAN,
            GREEN,
            PURPLE,
            BLUE,
            PINK,
            LIGHT_GREEN,
            GREY,
            BLACK,
    };
    private static final int[] tilesDayUnsolved = {
            MUTED_BLUE_U,
            RED_U,
            ORANGE_U,
            CYAN_U,
            GREEN_U,
            PURPLE_U,
            BLUE_U,
            PINK_U,
            LIGHT_GREEN_U,
            GREY_U,
            BLACK_U,
    };
    private static final int[] tilesNight = {
            MUTED_BLUE,
            RED,
            ORANGE,
            CYAN,
            GREEN,
            PURPLE,
            BLUE,
            PINK,
            LIGHT_GREEN,
            GREY,
            WHITE,
    };
    private static final int[] tilesNightUnsolved = {
            MUTED_BLUE_U,
            RED_U,
            ORANGE_U,
            CYAN_U,
            GREEN_U,
            PURPLE_U,
            BLUE_U,
            PINK_U,
            LIGHT_GREEN_U,
            GREY_U,
            WHITE_U,
    };
    public static final int[] multiColorTiles = {
            RED,
            BLUE,
            GREEN,
            ORANGE,
            PURPLE,
            MUTED_BLUE,
            GREY,
            LIGHT_GREEN,
            PINK,
            CYAN
    };
    public static final int ERROR = 0xffd24242;

    public static int getBackgroundColor() {
        return background[Settings.getColorMode()];
    }

    public static int getTileColor() {
        if (Settings.getColorMode() == Constants.COLOR_MODE_DAY) {
            return tilesDay[Settings.tileColor];
        } else {
            return tilesNight[Settings.tileColor];
        }
    }

    public static int[] getTileColors() {
        if (Settings.getColorMode() == Constants.COLOR_MODE_DAY) {
            return tilesDay;
        } else {
            return tilesNight;
        }
    }

    public static int getUnsolvedTileColor() {
        if (Settings.getColorMode() == Constants.COLOR_MODE_DAY) {
            return tilesDayUnsolved[Settings.tileColor];
        } else {
            return tilesNightUnsolved[Settings.tileColor];
        }
    }

    public static int getTileTextColor() {
        return spriteText[Settings.getColorMode()];
    }

    public static int getInfoTextColor() {
        return textInfo[Settings.getColorMode()];
    }

    public static int getOverlayColor() {
        return overlay[Settings.getColorMode()];
    }

    public static int getOverlayTextColor() {
        return overlayText[Settings.getColorMode()];
    }

    public static int getHardModeButtonsColor() {
        return Settings.getColorMode() == Constants.COLOR_MODE_DAY ? 0xff373737 : 0xff787878;
    }
}
