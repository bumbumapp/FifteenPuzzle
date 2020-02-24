package com.italankin.fifteen.views;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.italankin.fifteen.Colors;
import com.italankin.fifteen.Dimensions;
import com.italankin.fifteen.R;
import com.italankin.fifteen.Settings;

/**
 * Класс объединяет элементы интерфейса настроек и управляет их отрисовкой и поведением
 */
public class SettingsView extends BaseView {

    /**
     * заголовок элемента настроек
     */
    private Paint mPaintText;
    /**
     * значение элемента настроек
     */
    private Paint mPaintValue;
    /**
     * кнопки управления (назад)
     */
    private Paint mPaintControls;
    /**
     * для графического представления (например, цвет плиток)
     */
    private Paint mPaintIcon;

    /**
     * ширина поля
     */
    private String mTextWidth;
    private String mTextWidthValue;
    /**
     * высота поля
     */
    private String mTextHeight;
    private String mTextHeightValue;
    /**
     * hardmode
     */
    private String mTextBf;
    private String[] mTextBfValue;
    /**
     * анимации
     */
    private String mTextAnimations;
    private String[] mTextAnimationsValue;
    /**
     * цвет плиток
     */
    private String mTextColor;
    /**
     * режим fringer
     */
    private String mTextFringeColors;
    private String[] mTextFringeColorsValue;
    /**
     * цвет фона
     */
    private String mTextColorMode;
    /**
     * цветовая тема
     */
    private String[] mTextColorModeValue;
    /**
     * режим игры
     */
    private String mTextMode;
    private String[] mTextModeValue;
    /**
     * кнопка "назад"
     */
    private String mTextBack;

    /**
     * граница элемента настройки ширины
     */
    private RectF mRectWidth;
    /**
     * граница элемента высоты
     */
    private RectF mRectHeight;
    /**
     * граница элемента "слепого" режима
     */
    private RectF mRectBf;
    /**
     * граница элемента цвета
     */
    private RectF mRectColor;
    /**
     * режим fringe
     */
    private RectF mRectFringeColors;
    /**
     * граница элемента цвета фона
     */
    private RectF mRectColorMode;
    /**
     * граница элемента визуальное представление цвета
     */
    private RectF mRectColorIcon;
    /**
     * граница элемента анимации
     */
    private RectF mRectAnimations;
    /**
     * граница элемента режим игры
     */
    private RectF mRectMode;
    /**
     * граница элемента "назад"
     */
    private RectF mRectBack;
    /**
     * граница элемента "about"
     */
    //    private RectF mRectAbout;

    private Callbacks mCallbacks;

    public SettingsView(Resources res) {
        int lineSpacing = (int) (Dimensions.surfaceHeight * 0.082f); // промежуток между строками
        int topMargin = (int) (Dimensions.surfaceHeight * 0.05f); // отступ от верхнего края экрана
        int padding = -lineSpacing / 4;

        mPaintText = new Paint();
        mPaintText.setAntiAlias(Settings.antiAlias);
        mPaintText.setColor(Colors.getOverlayTextColor());
        mPaintText.setTextSize(Dimensions.menuFontSize);
        mPaintText.setTypeface(Settings.typeface);
        mPaintText.setTextAlign(Paint.Align.RIGHT);

        mPaintValue = new Paint();
        mPaintValue.setAntiAlias(Settings.antiAlias);
        mPaintValue.setColor(Colors.menuTextValue);
        mPaintValue.setTextSize(Dimensions.menuFontSize);
        mPaintValue.setTypeface(Settings.typeface);
        mPaintValue.setTextAlign(Paint.Align.LEFT);

        mPaintControls = new Paint(mPaintText);
        mPaintControls.setTextAlign(Paint.Align.CENTER);

        mPaintIcon = new Paint();
        mPaintIcon.setAntiAlias(Settings.antiAlias);

        mTextHeight = res.getString(R.string.pref_height);
        mTextHeightValue = Integer.toString(Settings.gameHeight);
        mTextWidth = res.getString(R.string.pref_width);
        mTextWidthValue = Integer.toString(Settings.gameWidth);
        mTextMode = res.getString(R.string.pref_mode);
        mTextModeValue = res.getStringArray(R.array.game_modes);
        mTextBf = res.getString(R.string.pref_bf);
        mTextBfValue = res.getStringArray(R.array.difficulty_modes);
        mTextAnimations = res.getString(R.string.pref_animation);
        mTextAnimationsValue = res.getStringArray(R.array.toggle);
        mTextFringeColors = res.getString(R.string.pref_fringe);
        mTextFringeColorsValue = res.getStringArray(R.array.multi_color_modes);
        mTextColorMode = res.getString(R.string.pref_color_mode);
        mTextColorModeValue = res.getStringArray(R.array.color_mode);
        mTextColor = res.getString(R.string.pref_color);
        mTextBack = res.getString(R.string.back);

        Rect r = new Rect();
        mPaintText.getTextBounds(mTextWidth, 0, mTextWidth.length(), r);
        int textHeight = r.height();

        topMargin += lineSpacing;
        mRectMode = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectMode.inset(0, padding);

        topMargin += lineSpacing;
        mRectBf = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectBf.inset(0, padding);

        topMargin += lineSpacing;
        mRectWidth = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectWidth.inset(0, padding);

        topMargin += lineSpacing;
        mRectHeight = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectHeight.inset(0, padding);

        topMargin += lineSpacing;
        mRectAnimations = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectAnimations.inset(0, padding);

        topMargin += lineSpacing;
        mRectColorMode = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectColorMode.inset(0, padding);

        topMargin += lineSpacing;
        mRectColor = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectColor.inset(0, padding);
        mRectColorIcon = new RectF(Dimensions.surfaceWidth / 2 + 2.0f * Dimensions.spacing,
                mRectColor.top - padding,
                Dimensions.surfaceWidth / 2 + 2.0f * Dimensions.spacing + textHeight,
                mRectColor.bottom + padding);
        mRectColorIcon.inset(-mRectColorIcon.width() / 4, -mRectColorIcon.width() / 4);

        topMargin += lineSpacing;
        mRectFringeColors = new RectF(0, topMargin, Dimensions.surfaceWidth, topMargin + textHeight);
        mRectFringeColors.inset(0, padding);

        mRectBack = new RectF(0, Dimensions.surfaceHeight - lineSpacing,
                Dimensions.surfaceWidth, Dimensions.surfaceHeight - lineSpacing + textHeight);
        mRectBack.inset(0, padding);
    }

    /**
     * Обработка событий нажатия
     *
     * @param x  координата x нажатия
     * @param y  координата y нажатия
     * @param dx направление жеста
     */
    public void onClick(int x, int y, int dx) {

        if (Math.abs(dx) < 15) {
            dx = 0;
        }

        // -- ширина поля --
        if (mRectWidth.contains(x, y)) {
            Settings.gameWidth += ((dx == 0) ? 1 : Math.signum(dx));
            if (Settings.gameWidth < Settings.MIN_GAME_WIDTH) {
                Settings.gameWidth = Settings.MAX_GAME_WIDTH;
            }
            if (Settings.gameWidth > Settings.MAX_GAME_WIDTH) {
                Settings.gameWidth = Settings.MIN_GAME_WIDTH;
            }
            Settings.save();
            if (mCallbacks != null) {
                mCallbacks.onChanged(true);
            }
        }

        // -- высота поля --
        if (mRectHeight.contains(x, y)) {
            Settings.gameHeight += ((dx == 0) ? 1 : Math.signum(dx));
            if (Settings.gameHeight < Settings.MIN_GAME_HEIGHT) {
                Settings.gameHeight = Settings.MAX_GAME_HEIGHT;
            }
            if (Settings.gameHeight > Settings.MAX_GAME_HEIGHT) {
                Settings.gameHeight = Settings.MIN_GAME_HEIGHT;
            }
            Settings.save();
            if (mCallbacks != null) {
                mCallbacks.onChanged(true);
            }
        }

        // -- переключение анимаций --
        if (mRectAnimations.contains(x, y)) {
            Settings.animations = !Settings.animations;
            Settings.save();
        }

        // -- цвет спрайтов --
        if (mRectColor.contains(x, y)) {
            int totalColors = Colors.getTileColors().length;
            if (dx < 0) {
                if (--Settings.tileColor < 0) {
                    Settings.tileColor += totalColors;
                }
            } else {
                Settings.tileColor = (++Settings.tileColor % totalColors);
            }
            Settings.save();
            if (mCallbacks != null) {
                mCallbacks.onChanged(false);
            }
        }

        // -- режим fringe --
        if (mRectFringeColors.contains(x, y)) {
            if (dx < 0) {
                if (--Settings.multiColor < 0) {
                    Settings.multiColor += Settings.MULTI_COLOR_MODES;
                }
            } else {
                Settings.multiColor = (++Settings.multiColor % Settings.MULTI_COLOR_MODES);
            }
            Settings.save();
            if (mCallbacks != null) {
                mCallbacks.onChanged(false);
            }
        }

        // -- цвет фона --
        if (mRectColorMode.contains(x, y)) {
            Settings.colorMode = (++Settings.colorMode % Settings.COLOR_MODES);
            Settings.save();
            if (mCallbacks != null) {
                mCallbacks.onChanged(false);
            }
        }

        // -- режим игры --
        if (mRectMode.contains(x, y)) {
            Settings.gameMode = (++Settings.gameMode % Settings.GAME_MODES);
            Settings.save();
            if (mCallbacks != null) {
                mCallbacks.onChanged(true);
            }
        }

        // -- режим игры --
        if (mRectBf.contains(x, y)) {
            Settings.hardmode = !Settings.hardmode;
            Settings.save();
            if (mCallbacks != null) {
                mCallbacks.onChanged(true);
            }
        }

        // -- назад --
        if (mRectBack.contains(x, y)) {
            hide();
        }
    }

    @Override
    public void draw(Canvas canvas, long elapsedTime) {
        if (!mShow) {
            return;
        }

        // отступ от центра
        float right = Dimensions.surfaceWidth / 2 + Dimensions.spacing;
        // для выравнивания элементов
        float left = Dimensions.surfaceWidth / 2 - Dimensions.spacing;
        // смещение по вертикали
        float s = (int) (Dimensions.surfaceHeight * 0.02f);

        // фон
        canvas.drawColor(Colors.getOverlayColor());

        // чтение настроек игры
        mTextWidthValue = Integer.toString(Settings.gameWidth);
        mTextHeightValue = Integer.toString(Settings.gameHeight);

        // ширина поля
        canvas.drawText(mTextWidth, left, mRectWidth.bottom - s, mPaintText);
        canvas.drawText(mTextWidthValue, right, mRectWidth.bottom - s, mPaintValue);

        // высота поля
        canvas.drawText(mTextHeight, left, mRectHeight.bottom - s, mPaintText);
        canvas.drawText(mTextHeightValue, right, mRectHeight.bottom - s, mPaintValue);

        // анимации
        canvas.drawText(mTextAnimations, left, mRectAnimations.bottom - s, mPaintText);
        canvas.drawText(mTextAnimationsValue[Settings.animations ? 1 : 0],
                right, mRectAnimations.bottom - s, mPaintValue);

        // цвет
        canvas.drawText(mTextColor, left, mRectColor.bottom - s, mPaintText);
        mPaintIcon.setColor(Colors.getTileColor());
        canvas.drawRect(mRectColorIcon, mPaintIcon);

        // fringe
        canvas.drawText(mTextFringeColors, left, mRectFringeColors.bottom - s, mPaintText);
        canvas.drawText(mTextFringeColorsValue[Settings.multiColor],
                right, mRectFringeColors.bottom - s, mPaintValue);

        // цвет фона
        canvas.drawText(mTextColorMode, left, mRectColorMode.bottom - s, mPaintText);
        canvas.drawText(mTextColorModeValue[Settings.colorMode],
                right, mRectColorMode.bottom - s, mPaintValue);

        // режим
        canvas.drawText(mTextMode, left, mRectMode.bottom - s, mPaintText);
        canvas.drawText(mTextModeValue[Settings.gameMode],
                right, mRectMode.bottom - s, mPaintValue);

        // bf
        canvas.drawText(mTextBf, left, mRectBf.bottom - s, mPaintText);
        canvas.drawText(mTextBfValue[Settings.hardmode ? 1 : 0],
                right, mRectBf.bottom - s, mPaintValue);

        // кнопка "назад"
        canvas.drawText(mTextBack, mRectBack.centerX(),
                mRectBack.bottom - s, mPaintControls);
    }

    public void update() {
        mPaintText.setColor(Colors.getOverlayTextColor());
        mPaintControls.setColor(Colors.getOverlayTextColor());
        mPaintValue.setColor(Colors.menuTextValue);

        mPaintText.setAntiAlias(Settings.antiAlias);
        mPaintControls.setAntiAlias(Settings.antiAlias);
        mPaintValue.setAntiAlias(Settings.antiAlias);
        mPaintIcon.setAntiAlias(Settings.antiAlias);
    }

    public void addCallback(Callbacks callbacks) {
        mCallbacks = callbacks;
    }

    public interface Callbacks {

        void onChanged(boolean needUpdate);
    }
}
