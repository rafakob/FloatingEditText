# FloatingEditText

TextInputLayout and TextInputEditText merged into one class. Just for convenience and for removing some boilerplate code.

## Description
Instead of writing this:
```xml
<android.support.design.widget.TextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="16dp"
    android:hint="Example"
    app:hintAnimationEnabled="true"
    app:hintTextAppearance="@style/HintTextAppearance">

    <android.support.design.widget.TextInputEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:fontFamily="sans-serif-light"
        android:imeOptions="actionDone"
        android:inputType="textCapWords|textEmailAddress"
        android:maxLength="100"
        android:maxLines="2"
        android:textAllCaps="true"
        android:textColor="?colorPrimary"
        android:textSize="24sp"
        android:textStyle="italic"/>

</android.support.design.widget.TextInputLayout>
```

You can write this:
```xml
<com.rafakob.floatingedittext.FloatingEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="16dp"
    android:fontFamily="sans-serif-light"
    android:hint="Example"
    android:imeOptions="actionDone"
    android:inputType="textCapWords|textEmailAddress"
    android:maxLength="100"
    android:maxLines="2"
    android:textAllCaps="true"
    android:textColor="?colorPrimary"
    android:textSize="24sp"
    android:textStyle="italic"
    app:hintAnimationEnabled="true"
    app:hintTextAppearance="@style/HintTextAppearance"/>
```

| Method | Description |
|---|---|
| `String getText()` | Get text from `EditText` |
| `void setText(String text)` | Set text to `EditText` |
| `void setError(@StringRes int errorRes)` | Set error using string resource |
| `void setHint(@StringRes int hintRes)` | Set hint using string resource |
| `void addTextChangedListener(TextWatcher textWatcher)` | Add `TextWatcher` |
| `void removeTextChangedListener(TextWatcher textWatcher)` | Remove `TextWatcher` |
| `EditText getEditText()` | Return the `EditText` which is annotated with `@NonNull` |

## Install
[ ![Download](https://api.bintray.com/packages/rafakob/maven/FloatingEditText/images/download.svg) ](https://bintray.com/rafakob/maven/FloatingEditText/_latestVersion)

```java
compile 'com.rafakob:floatingedittext:latest_version'
```
