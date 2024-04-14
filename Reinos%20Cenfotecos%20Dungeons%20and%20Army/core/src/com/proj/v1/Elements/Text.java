package com.proj.v1.Elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.proj.v1.Utils.Render;
import com.proj.v1.Utils.Resources;

import static com.proj.v1.Utils.Render._Batch;


public class Text {
    private static final Color FONT_COLOR= Color.WHITE;
    private BitmapFont _Font;
    private GlyphLayout _GLayout;
    private Float _X,_Y;
    private int _FontSize = 25;
    private String _Text;

    //CONSTRUCTORES

    public Text() {
        initLayout();
        generateText(Resources.MENU_FONT,this._FontSize,FONT_COLOR,false);
        this.setCoordinates(100,100);
        this.setText("");
    }

    public Text(String pFontPath, Float pX, Float pY, int pFontSize, String pText) {
        initLayout();
        generateText(pFontPath,pFontSize,FONT_COLOR,false);
        this.setCoordinates(pX,pY);
        this.setText(pText);
    }

    public Text(String pFontPath, Float pX, Float pY, int pFontSize, String pText, Boolean pShadow) {
        initLayout();
    }

    public Text(String pFontPath, Float pX, Float pY, int pFontSize, String pText, Color pColor) {
        initLayout();
        generateText(pFontPath,pFontSize,pColor,false);
        this.setCoordinates(pX,pY);
        this.setText(pText);
    }

    public Text(String pFontPath, Float pX, Float pY, int pFontSize, String pText, Color pColor, Boolean pShadow) {
        initLayout();
        generateText(pFontPath,pFontSize,pColor,false);
        this.setCoordinates(pX,pY);
        this.setText(pText);
    }

    public Text(String pText, int pFontSize, String pFontSource) {
        initLayout();
        generateText(Resources.MENU_FONT,pFontSize, FONT_COLOR,false);
        this.setCoordinates(1f,1f);
        this.setText(pText);
    }

    public Text(String pText, int pFontSize) {
        initLayout();
        generateText(Resources.MENU_FONT,pFontSize, FONT_COLOR,false);
        this.setCoordinates(1f,1f);
        this.setText(pText);
    }

    //GET & SET
    public BitmapFont getFont() {
        return _Font;
    }

    public GlyphLayout getGLayout() {
        return _GLayout;
    }

    public Float getX() {
        return _X;
    }

    public Float getY() {
        return _Y;
    }

    public int getFontSize() {
        return _FontSize;
    }

    public String getText() {
        return _Text;
    }

    public float getWidth() {
        return this.getGLayout().width;
    }

    public float getHeight() {
        return this.getGLayout().height;
    }

    public void setFont(BitmapFont _Font) {
        this._Font = _Font;
    }

    public void setGLayout(GlyphLayout _GLayout) {
        this._GLayout = _GLayout;
    }

    public void setX(Float _X) {
        this._X = _X;
    }

    public void setY(Float _Y) {
        this._Y = _Y;
    }

    public void setFontSize(int _FontSize) {
        this._FontSize = _FontSize;
    }

    public void setText(String pText) {
        this._Text = pText;
        this._GLayout.setText(this._Font, pText);

    }

    public void setCoordinates(float pX, float pY){
        this.setX(pX);
        this.setY(pY);
    }

    public void setColor(Color pColor){

        this.getFont().setColor(pColor);
    }

    //PUBLIC FUNCTIONS
    public void draw(){
        this._Font.draw(Render._Batch,this.getText(),this.getX(),this.getY());
    }

    public void centerTextScreen(){
        float w =(Resources.WIDTH/2) - (this.getWidth()/2);
        float h =(Resources.HEIGHT/2) - (this.getHeight()/2);
        this.setCoordinates(w,h);
    }




    //PRIVATE FUNCTIONS
    private void generateText(String pFontPath, int pFontSize, Color pColor, Boolean pShadow){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(pFontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        //Algunas ediciones del texto
        parameter.size = pFontSize;
        parameter.color = pColor;
        if (pShadow){
            parameter.shadowOffsetX = 1;
            parameter.shadowOffsetY = 4;
            parameter.shadowColor = com.badlogic.gdx.graphics.Color.BLACK;
        }
        this.setFontSize(pFontSize);
        this._Font = generator.generateFont(parameter);
    }

    private void initLayout(){
        this._GLayout = new GlyphLayout();
    }


}
