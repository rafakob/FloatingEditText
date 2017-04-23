package com.rafakob.floatingedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

public class FloatingEditText extends TextInputLayout {
    private TextInputEditText editText;

    public FloatingEditText(Context context) {
        super(context);
        setup(context, null, 0);
    }

    public FloatingEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(context, attrs, 0);
    }

    public FloatingEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context, attrs, defStyleAttr);
    }

    private void setup(Context context, AttributeSet attrs, int defStyleAttr) {
        editText = new TextInputEditText(context);

        if (attrs != null) {
            TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FloatingEditText, 0, 0);

            if (ta.hasValue(R.styleable.FloatingEditText_android_text)) {
                editText.setText(ta.getString(R.styleable.FloatingEditText_android_text));
            }

            if (ta.hasValue(R.styleable.FloatingEditText_android_textAllCaps)) {
                editText.setAllCaps(ta.getBoolean(R.styleable.FloatingEditText_android_textAllCaps, false));
            }

            if (ta.hasValue(R.styleable.FloatingEditText_android_textColor)) {
                editText.setTextColor(ta.getColor(R.styleable.FloatingEditText_android_textColor, 0));
            }

            if (ta.hasValue(R.styleable.FloatingEditText_android_textSize)) {
                editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, ta.getDimensionPixelSize(R.styleable.FloatingEditText_android_textSize, 0));
            }

            int textStyle = Typeface.NORMAL;
            if (ta.hasValue(R.styleable.FloatingEditText_android_textStyle)) {
                textStyle = ta.getInt(R.styleable.FloatingEditText_android_textStyle, Typeface.NORMAL);
            }

            String fontFamily = "sans-serif";
            if (ta.hasValue(R.styleable.FloatingEditText_android_fontFamily)) {
                fontFamily = ta.getString(R.styleable.FloatingEditText_android_fontFamily);
            }

            editText.setTypeface(Typeface.create(fontFamily, textStyle));

            if (ta.hasValue(R.styleable.FloatingEditText_android_inputType)) {
                editText.setInputType(ta.getInt(R.styleable.FloatingEditText_android_inputType, -1));
            }

            if (ta.hasValue(R.styleable.FloatingEditText_android_imeOptions)) {
                editText.setImeOptions(ta.getInt(R.styleable.FloatingEditText_android_imeOptions, -1));
            }

            if (ta.hasValue(R.styleable.FloatingEditText_android_maxLength)) {
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(ta.getInt(R.styleable.FloatingEditText_android_maxLength, 0))});
            }

            if (ta.hasValue(R.styleable.FloatingEditText_android_maxLines)) {
                editText.setMaxLines(ta.getInt(R.styleable.FloatingEditText_android_maxLines,1));
            }

            ta.recycle();
        }

        addView(editText);
    }

    public String getText() {
        return editText.getText().toString();
    }

    public void setText(String text) {
        editText.setText(text);
    }

    public void setError(@StringRes int errorRes) {
        setError(getContext().getString(errorRes));
    }

    public void setHint(@StringRes int hintRes) {
        setHint(getContext().getString(hintRes));
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        editText.addTextChangedListener(textWatcher);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        editText.removeTextChangedListener(textWatcher);
    }

    @NonNull
    public EditText getEditText() {
        return editText;
    }
}
