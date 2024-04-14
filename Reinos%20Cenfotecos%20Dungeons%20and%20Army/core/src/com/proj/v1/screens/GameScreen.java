package com.proj.v1.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import com.proj.v1.ProxyMethod.BaulProxy;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.proj.v1.Elements.Command.Command;
import com.proj.v1.Elements.Command.Player1Command;
import com.proj.v1.Elements.Command.Player2Command;
import com.proj.v1.Elements.CompositeBoard.Block;
import com.proj.v1.Elements.CompositeBoard.Board2;
import com.proj.v1.Elements.CompositeBoard.Row;
import com.proj.v1.FabricMethodPattern.Characters.Character;
import com.proj.v1.FabricMethodPattern.Concrete_Fabrics.Character_Fabric;
import com.proj.v1.CountdownTimer.Countdown;
import com.proj.v1.Elements.*;

import com.proj.v1.FlyweightPattern.ConcreteFleyweightNotShared.CharacterWithPoints;
import com.proj.v1.FlyweightPattern.IFlyweight.IFlyweight;
import com.proj.v1.MementoPattern.Caretaker;
import com.proj.v1.MementoPattern.Memento;
import com.proj.v1.PrototypePattern.APrototype.ASquare;
import com.proj.v1.PrototypePattern.Prefas.*;
import com.proj.v1.PrototypePattern.Prototype.Square;
import com.proj.v1.Utils.Resources;
import com.proj.v1.Utils.TimerCallback;
import com.proj.v1.Viewer.Concreto.ChangePlayer;
import com.proj.v1.Viewer.Concreto.ChangeTurn;

import java.util.ArrayList;
import java.util.Timer;

import static com.proj.v1.PrototypePattern.APrototype.ASquare._SIZE_PREFA;
import static com.proj.v1.Utils.Render._Batch;
import static com.proj.v1.Utils.Resources.SKIN_PATH;

public class GameScreen implements Screen {
    private ChangeTurn CT;

    BaulProxy baul = new BaulProxy();

    private ChangePlayer CP;
    private ArrayList<CharacterWithPoints> _CharactersList = new ArrayList<>();

    private Image _Background;
    private Stage _Stage = new Stage();
    private Button _GiveUpButton;
    private Button _AttackButton;
    private Button _DiceCountButton;
    private Button _EndTurnButton;

    private Button _BaulButton;
    private Button _SaveButton;
    private Button _FlipButton;
    private Button _ResetButton;
    private Button _ChangePrefaButton;
    private Character_Fabric _Fabric;
    private Character _Castle1;
    private Character _Castle2;

    private PrefaTablero prefaTablero;
    private LinePrefa _LinePrefa;

    private LPrefa _LPrefa;
    private TPrefa _TPrefa;
    private CPrefa _CPrefa;
    private SPrefa _SPrefa;
    private SquadPrefa _SquadPrefa;
    private XPrefa _XPrefa;

    /**Para colorear Tablero, prefas*/
    private Board _Board;
    private Board2 _Board2;
    private ShapeRenderer _Border;
    private ShapeRenderer _FilledBlue;
    private ShapeRenderer _FilledRed;
    private ShapeRenderer _FilledCYAN;
    private ShapeRenderer _FilledPrefas;

    private Skin skin;

    private ArrayList<Float> _Positions;

    private Text _Timer;
    private Text _PlayerTurn;
    private Timer timer;
    public String[] players;
    private String currentPlayer;
    private static int _Count = 1;
    private static int _Rotate = 1;
    int x =0; /***/
    int y =0; /***/
    double _DifferenceX;
    double _DifferenceY;

    private CharacterWithPoints _CharacterWPoints;
    private IFlyweight _IFlyweight;
    private boolean cosa = false;

    private DefineFirstPlayer defineFirst;

    private boolean _BlueTurn;
    private Caretaker _caretaker = new Caretaker();

    private Text _InfantryNumber_Player1;
    private Text _InfantryNumber_Player2;
    private Text _TankNumber_Player1;
    private Text _TankNumber_Player2;
    private Text _Artillery_Player1;
    private Text _Artillery_Player2;

    private Text _InfantryLabel;
    private Text _ArtilleryLabel;
    private Text _TankLabel;

    private Text _Player1Label;
    private Text _Player2Label;

    public GameScreen(){
        timer = new Timer();
    }

    public GameScreen(String firstPlayer, String secondPlayer){
        prefaTablero = new PrefaTablero();
        timer = new Timer();
        players = new String[]{firstPlayer, secondPlayer};
        defineFirst = new DefineFirstPlayer();
        CP = new ChangePlayer();
        CT = new ChangeTurn();
    }

    @Override
    public void show() {
        setbackground();
        _Stage = new Stage();

        _Positions = new ArrayList<Float>();
        for(int x = 0; x < 24; x++){
            Float position = (float) ((x * _SIZE_PREFA)+1035);
            _Positions.add(position);
        }

        skin = new Skin(Gdx.files.internal(SKIN_PATH));

        _Board2 =  new Board2();

        setBoard();
        buttonsInit();
        setButtonsFunctionality();
        charactersInit();
        prefasInit();
        trunkInformation();
        //Countdown Timer
        this._Timer = new Text(Resources.TIMER_FONT, 1200f, 1035f, 35,"Tiempo: 60");
        currentPlayer = players[defineFirst.defineFirstPlayer()];
        this._PlayerTurn = new Text(Resources.TIMER_FONT, 160f, 110f, 35,"Juega: "+ currentPlayer);
        startTimer();
        //Se guarda los estados de los objetos
        saveGame();
    }


    @Override
    public void render(float delta) {
        this._Border.begin(ShapeRenderer.ShapeType.Line);
        this._Border.setColor(Color.CYAN);
        this._Border.setProjectionMatrix(_Batch.getProjectionMatrix());

        this._FilledCYAN.begin(ShapeRenderer.ShapeType.Filled);
        this._FilledCYAN.setColor(Color.CYAN);
        this._FilledCYAN.setProjectionMatrix(_Batch.getProjectionMatrix());

        this._FilledPrefas.begin(ShapeRenderer.ShapeType.Filled);
        this._FilledPrefas.setProjectionMatrix(_Batch.getProjectionMatrix());

        this._FilledRed.begin(ShapeRenderer.ShapeType.Filled);
        this._FilledRed.setColor(Color.RED);
        this._FilledRed.setProjectionMatrix(_Batch.getProjectionMatrix());

        this._FilledBlue.begin(ShapeRenderer.ShapeType.Filled);
        this._FilledBlue.setColor(Color.BLUE);
        this._FilledBlue.setProjectionMatrix(_Batch.getProjectionMatrix());

        /** Colorear prefas en tablero de acuerdo al jugador*/
        colorPrefasByPlayer();

        /**Pintar tablero*/
        renderBoard();

        /**Render prefas a escoger */
        ArrayList<Square> _PrefaToAddToBoard = renderPrefa();
        /**Colocar prefas en el tablero*/
        putPrefasInBoard(_PrefaToAddToBoard);

        _Batch.begin();
        _Background.draw();

        //Countdowm timer
        _Timer.draw();
        _PlayerTurn.draw();

        /**Baúl etiquetas*/
        _Player1Label.draw();
        _Player2Label.draw();
        _ArtilleryLabel.draw();
        _TankLabel.draw();
        _InfantryLabel.draw();

        /**Baúl etiquetas*/
        _InfantryNumber_Player1.draw();
        _InfantryNumber_Player2.draw();
        _TankNumber_Player1.draw();
        _TankNumber_Player2.draw();
        _Artillery_Player1.draw();
        _Artillery_Player2.draw();

        _BlueTurn = currentPlayer.equals(players[1]);

        /**Pintar castilllos*/
        _Castle2.draw(_Batch);
        _Castle1.draw(_Batch);
        _Batch.end();

        this._Border.end();
        this._FilledRed.end();
        this._FilledCYAN.end();
        this._FilledBlue.end();
        this._FilledPrefas.end();

        _Batch.begin();
        /**pintar las tropas*/
        for(CharacterWithPoints x: _CharactersList){
            x._VisualDataCharacter.draw(_Batch);
        }
        _Batch.end();
        _Stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void startTimer(){
        timer.schedule(new Countdown(60, _Timer, _PlayerTurn, players, new TimerCallback() {
            @Override
            public void onfinish() {

                finishPlayerTurn();
            }
        }), 0, 1000);
    }

    public void renderBoard(){
        //Añadimos columnas
        Block block = new Block('▢');
        Row row = new Row();
        Board2 board = new Board2();

        int Y =0;
        for (int X = 0; X < 24;  X++) {
            for (Y = 0; Y < 17; Y++) {
                float _X = (float) ((X * _SIZE_PREFA)+1035);
                float _Y = ((float) (770-(Y * _SIZE_PREFA)));
                this._Border.rect(_X, _Y, 30, 30);
                row.addBlock(block);
                board.addRow(row);
            }

        }
       _Board2.render();

        /**Pintar las prefas del tablero de acuerdo al jugador que pertenecen*/

        for (Board _B: _Board.get_ListBoard()){

             if(_B.is_WithPrefa()){

                 if(_B.get_player() == 1){
                     this._FilledBlue.rect(_B.get_XPosition()+1, _B.get_YPosition()+1, ASquare._WIDTH-2, ASquare._HEIGHT-2);
                  }else{
                      this._FilledRed.rect(_B.get_XPosition()+1, _B.get_YPosition()+1, ASquare._WIDTH-2, ASquare._HEIGHT-2);
                  }
            }
        }
    }

    public void putPrefasInBoard(ArrayList<Square> _PrefaToAddToBoard){
        boolean haveTroops =false;
        boolean _NotAllowed = false;
        boolean _FirstPrefa = true;
        boolean _PrefasNextTo = false;
        int prefaX = 0;
        int prefaY = 0;

        if(Gdx.input.justTouched()){
            this.x = Gdx.input.getX();
            this.y = Resources.HEIGHT -Gdx.input.getY();

            //print("x:" + this.x + " y:"+ this.y);
            if(this.x >= 1035 && this.x<=1755 && this.y <= 790 && this.x>= 260){
                for (Board _B: _Board.get_ListBoard()){
                    if(this.x> _B.get_XPosition() && this.x <_B.get_XPosition()+30 && this.y> _B.get_YPosition() && this.y <_B.get_YPosition()+30){
                        _DifferenceX = _B.get_XPosition() - _PrefaToAddToBoard.get(0).get_X();
                        _DifferenceY = _B.get_YPosition() - _PrefaToAddToBoard.get(0).get_Y();
                    }
                    /**Verificar si el jugador ha puesto otras prefas*/
                    if(_BlueTurn){
                        if(_B.is_WithPrefa() && _B.get_player() == 1){
                            _FirstPrefa = false;
                        }
                    }else{
                        if(_B.is_WithPrefa() && _B.get_player() == 2){
                            _FirstPrefa = false;
                        }
                    }

                }
                for (Board _B: _Board.get_ListBoard()){
                    for(Square _Prefa: _PrefaToAddToBoard){
                        prefaX = (int) (_Prefa.get_X()+_DifferenceX);
                        prefaY = (int) (_Prefa.get_Y() + _DifferenceY);
                        if(prefaX == _B.get_XPosition() && prefaY == _B.get_YPosition()){
                            /**Verificar que el cuadro del Board no tenga prefas*/

                            if(_B.is_WithPrefa()){
                                _NotAllowed = true;
                            }

                            if(_B.get_IsWithPrefaByCoordinates((int) (_B.get_XPosition()+30), (int) (_B.get_YPosition()))){
                                _PrefasNextTo = true;
                            };

                            if(_B.get_IsWithPrefaByCoordinates((int) (_B.get_XPosition()-30), (int) (_B.get_YPosition()))){
                                _PrefasNextTo = true;
                            }
                            if(_B.get_IsWithPrefaByCoordinates((int) (_B.get_XPosition()), (int) (_B.get_YPosition()+30))){
                                _PrefasNextTo = true;
                            };
                            if(_B.get_IsWithPrefaByCoordinates((int) (_B.get_XPosition()), (int) (_B.get_YPosition()-30))){
                                _PrefasNextTo = true;

                            };

                        }


                    }
                }

                /**Verificar que el primer paso sea al frente del castillo*/
                if(_FirstPrefa) {
                    if (_BlueTurn) {
                        if (_PrefaToAddToBoard.get(0).get_X() + _DifferenceX != _Castle1.get_X() || _PrefaToAddToBoard.get(0).get_Y() + _DifferenceY != (_Castle1.get_Y() - _SIZE_PREFA)) {
                            _NotAllowed = true;
                        }
                    } else {
                        if (_PrefaToAddToBoard.get(0).get_X() + _DifferenceX != _Castle2.get_X() || _PrefaToAddToBoard.get(0).get_Y() + _DifferenceY != (_Castle2.get_Y() + _SIZE_PREFA)) {
                            _NotAllowed = true;
                        }
                    }
                }
                prefaX = (int) (_PrefaToAddToBoard.get(0).get_X() + _DifferenceX);
                System.out.println("Prefa X  en board: " + prefaX);
                prefaY = (int) (_PrefaToAddToBoard.get(0).get_Y() + _DifferenceY);
                System.out.println("Prefa Y  en board: " + prefaY);

                if(!_NotAllowed ) {
                    /**Evaluar que haya tropas*/
                    System.out.println("Verifico que hayan unidades");
                    if(_BlueTurn){
                        if(Player1Command.cantidadInfanteria>0){
                            invokeInfantry(prefaX, prefaY);
                            haveTroops = true;
                            Player1Command.cantidadInfanteria--;
                            _InfantryNumber_Player1.setText(String.valueOf(Player1Command.cantidadInfanteria));
                        }else if(Player1Command.cantidadArquero>0){
                            invokeArtillery(prefaX, prefaY);
                            haveTroops = true;
                            _Artillery_Player1.setText(String.valueOf(Player1Command.cantidadArquero));
                            Player1Command.cantidadArquero--;
                        }else if(Player1Command.cantidadTanque>0){
                            invokeTank(prefaX, prefaY);
                            haveTroops = true;
                            Player1Command.cantidadTanque--;
                            _TankNumber_Player1.setText(String.valueOf(Player1Command.cantidadTanque));
                        }
                    }else{
                        if(Player2Command.cantidadInfanteria>0){
                            invokeInfantry(prefaX, prefaY);
                            haveTroops = true;
                            Player2Command.cantidadInfanteria--;
                            _InfantryNumber_Player2.setText(String.valueOf(Player2Command.cantidadInfanteria));
                        }else if(Player2Command.cantidadArquero>0){
                            invokeArtillery(prefaX, prefaY);
                            haveTroops = true;
                            Player2Command.cantidadArquero--;
                            _Artillery_Player2.setText(String.valueOf(Player2Command.cantidadArquero));
                        }else if(Player2Command.cantidadTanque>0){
                            invokeTank(prefaX, prefaY);
                            haveTroops = true;
                            Player2Command.cantidadTanque--;
                            _TankNumber_Player2.setText(String.valueOf(Player2Command.cantidadTanque));
                        }
                    }
                    BaulProxy baulJugador1 = new BaulProxy();
                    Command commandJugador1 = new Player1Command(baulJugador1);

                    BaulProxy baulJugador2 = new BaulProxy();
                    Command commandJugador2 = new Player2Command(baulJugador2);
                    if(_BlueTurn){
                        commandJugador1.execute(_BlueTurn);
                        _InfantryNumber_Player1.setText(String.valueOf(Player1Command.cantidadInfanteria));

                        _TankNumber_Player1.setText(String.valueOf(Player1Command.cantidadTanque));
                        _Artillery_Player1.setText(String.valueOf(Player1Command.cantidadArquero));
                    }else {
                        commandJugador2.execute(_BlueTurn);

                        _InfantryNumber_Player2.setText(String.valueOf(Player2Command.cantidadInfanteria));


                        _TankNumber_Player2.setText(String.valueOf(Player2Command.cantidadTanque));

                        _Artillery_Player2.setText(String.valueOf(Player2Command.cantidadArquero));
                    }
                    if(haveTroops){
                        changeBoardWithPrefa(_PrefaToAddToBoard);
                    }
                }
            }
        }
    }


    /**Cambiar cuadro de Board a Cuadro con prefa o con personaje*/
    public void changeBoardWithPrefa(ArrayList<Square> _PrefaToAddToBoard){
        int _CountFor =  0;

        for (Board _B: _Board.get_ListBoard()){
            for(Square _Prefa: _PrefaToAddToBoard){
                if(_Prefa.get_X()+_DifferenceX == _B.get_XPosition() && _Prefa.get_Y() + _DifferenceY== _B.get_YPosition()){
                    _B.set_WithPrefa(true);
                    /**Setea el primer cuadro de la prefa con personaje*/
                    if(_CountFor ==0){
                        _B.set_WithCharacter(true);
                    }
                    /**Establece el dueño de la prefa en el Board */
                    if(_BlueTurn) {
                        _B.set_player(1); //BLUE
                    }else{
                        _B.set_player(2);
                    }
                    _CountFor++;

                }
            }
        }
    }

    public void colorPrefasByPlayer(){
        if(_BlueTurn){
            changeColor(CP.turn(_BlueTurn));
            _FilledCYAN.rect(_Castle1.get_X(), (float) (_Castle1.get_Y() - _SIZE_PREFA), ASquare._WIDTH, ASquare._HEIGHT);
        }else{
            changeColor(CP.turn(_BlueTurn));
            _FilledCYAN.rect(_Castle2.get_X(), (float) (_Castle2.get_Y() + _SIZE_PREFA),ASquare._WIDTH, ASquare._HEIGHT);
        }
    }

    public void changeColor(boolean change){
        if(change)
            this._FilledPrefas.setColor(Color.BLUE);
        else
            this._FilledPrefas.setColor(Color.RED);
    }

    public void finishPlayerTurn(){
        timer.cancel();
        CT.setTurn(_BlueTurn);
        currentPlayer = currentPlayer.equals(players[0]) ? players[1] : players[0];
        _PlayerTurn.setText("Juega: "+ currentPlayer);
        _BlueTurn = !_BlueTurn;
        timer = new Timer();
        startTimer();
        Player1Command.oneTime = true;
        Player2Command.oneTime = true;
    }

    public void setbackground(){
        this._Background = new Image(Resources.GAME_BACKGROUND);
        this._Background.setSize(Resources.HEIGHT, Resources.WIDTH);
    }

    public void setBoard(){
        _Board = new Board();
        _Board.drawBoard();

        this._Border = new ShapeRenderer();
        this._FilledBlue = new ShapeRenderer();
        this._FilledCYAN = new ShapeRenderer();
        this._FilledRed = new ShapeRenderer();
        Gdx.input.setInputProcessor(_Stage);
        skin = new Skin(Gdx.files.internal(SKIN_PATH));
    }
    public void charactersInit(){
        _Fabric = new Character_Fabric();

        _Castle1 = _Fabric.createCharacter(1, _Positions.get(Character.getRandomPosition()), 800f, "Characters/Castle.png");
        _Castle2 = _Fabric.createCharacter(1, _Positions.get(Character.getRandomPosition()), 260f, "Characters/Castle.png");
        _Castle2.UpDown();

    }

    public void invokeArtillery(int pX, int pY){
        if(_BlueTurn){
            _CharacterWPoints = new CharacterWithPoints("Characters/Artillero-2.png");
            _CharacterWPoints._VisualDataCharacter.set_X(pX+4);
            _CharacterWPoints._VisualDataCharacter.set_Y(pY+4);
            _CharactersList.add(_CharacterWPoints);
            //print(_CharacterWPoints.showCharacteristics());
        }else{
            _CharacterWPoints = new CharacterWithPoints("Characters/Artillero-1.png");
            _CharacterWPoints._VisualDataCharacter.set_X(pX+4);
            _CharacterWPoints._VisualDataCharacter.set_Y(pY+4);
            _CharactersList.add(_CharacterWPoints);

            //print(_CharacterWPoints.showCharacteristics());

        }
    }
    public void invokeTank(int pX, int pY){
        if(_BlueTurn){
            _CharacterWPoints = new CharacterWithPoints("Characters/Tanque-2.png");
            _CharacterWPoints._VisualDataCharacter.set_X(pX+4);
            _CharacterWPoints._VisualDataCharacter.set_Y(pY+4);
            _CharactersList.add(_CharacterWPoints);
            //print(_CharacterWPoints.showCharacteristics());
        }else{
            _CharacterWPoints = new CharacterWithPoints("Characters/Tanque-1.png");
            _CharacterWPoints._VisualDataCharacter.set_X(pX+4);
            _CharacterWPoints._VisualDataCharacter.set_Y(pY+4);
            _CharactersList.add(_CharacterWPoints);
            //print(_CharacterWPoints.showCharacteristics());
        }
    }
    public void invokeInfantry(int pX, int pY){
        if(_BlueTurn){
            _CharacterWPoints = new CharacterWithPoints("Characters/Infanteria-2.png");
            _CharacterWPoints._VisualDataCharacter.set_X(pX+4);
            _CharacterWPoints._VisualDataCharacter.set_Y(pY+4);
            _CharactersList.add(_CharacterWPoints);
            //print(_CharacterWPoints.showCharacteristics());
        }else{
            _CharacterWPoints = new CharacterWithPoints("Characters/Infanteria-1.png");
            _CharacterWPoints._VisualDataCharacter.set_X(pX+4);
            _CharacterWPoints._VisualDataCharacter.set_Y(pY+4);
            _CharactersList.add(_CharacterWPoints);
            //print(_CharacterWPoints.showCharacteristics());

        }
    }

    public void setButtonsFunctionality(){
        _GiveUpButton.changeScreen(new FirstScreen());
        _ResetButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                restore(_caretaker.getMemento());
            }
        });
//        _DiceCountButton.rollInvocation();
//        _DiceCountButton.rollMove();
        _DiceCountButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                BaulProxy baulJugador1 = new BaulProxy();
                Command commandJugador1 = new Player1Command(baulJugador1);

                BaulProxy baulJugador2 = new BaulProxy();
                Command commandJugador2 = new Player2Command(baulJugador2);
                if(_BlueTurn){
                    commandJugador1.execute(_BlueTurn);
                    _InfantryNumber_Player1.setText(String.valueOf(Player1Command.cantidadInfanteria));

                    _TankNumber_Player1.setText(String.valueOf(Player1Command.cantidadTanque));
                    _Artillery_Player1.setText(String.valueOf(Player1Command.cantidadArquero));
                }else {
                    commandJugador2.execute(_BlueTurn);

                    _InfantryNumber_Player2.setText(String.valueOf(Player2Command.cantidadInfanteria));


                    _TankNumber_Player2.setText(String.valueOf(Player2Command.cantidadTanque));

                    _Artillery_Player2.setText(String.valueOf(Player2Command.cantidadArquero));
                }
                DiceResult popup = new DiceResult("Resultado", skin);
                popup.show(_Stage);
            }
        });
        _EndTurnButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                finishPlayerTurn();
            }
        });

        _FlipButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                _Rotate++;
                if(_Rotate> 4){
                    _Rotate =1;
                }
            }
        });

        _ChangePrefaButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                _Count++;
                if(_Count> 7){
                    _Count =1;
                }
            }
        });


        /*_BaulButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                /*baul.selectInvocation();
                baul.selectInvocation();
                baul.selectMove();
                baul.selectMove();


                BaulSelect popup = new BaulSelect("Baul", skin);

                if(_BlueTurn) {
                    popup.baulLlenarPlayer1();

                } else {
                    popup.baulLlenarPlayer2();
                }
                popup.show(_Stage);
            }
        });*/

    }
    public void buttonsInit(){
        //GiveUpButtons
        _GiveUpButton = new Button(65, 120, 0.18, 0.985, "Rendirse");
        _Stage.addActor(_GiveUpButton);

        _ResetButton = new Button(65, 150, 0.28, 0.985, "Resetear Juego");
        _Stage.addActor(_ResetButton);

        _AttackButton = new Button(65, 270, 0.105, 0.463, "Atacar");
        _Stage.addActor(_AttackButton);

        //Dices
        _DiceCountButton = new Button(65, 270, 0.11, 0.345, "Tirar dados");
        _Stage.addActor(_DiceCountButton);

        _SaveButton = new Button(65, 270, 0.31, 0.345, "Guardar");
        _Stage.addActor(_SaveButton);

        _EndTurnButton = new Button(65, 270, 0.31, 0.463, "Terminar turno");
        _Stage.addActor(_EndTurnButton);

        _FlipButton = new Button(65, 200, 0.92, 0.048, "Girar");
        _Stage.addActor(_FlipButton);

        _ChangePrefaButton = new Button(65, 200, 0.6, 0.048, "Cambiar");
        _Stage.addActor(_ChangePrefaButton);

        //_BaulButton = new Button(65, 270, 0.31, 0.250, "Baul");
        //_Stage.addActor(_BaulButton);
    }



    public void prefasInit(){
        _FilledPrefas = new ShapeRenderer();
        _LinePrefa = new LinePrefa();
        _LinePrefa.drawPrefa();
        _LinePrefa.drawPrefaTurned();
        _LPrefa = new LPrefa();
        _LPrefa.drawPrefa();
        _LPrefa.drawPrefaTurned90();
        _LPrefa.drawPrefaTurned180();
        _LPrefa.drawPrefaTurned270();
        _TPrefa = new TPrefa();
        _TPrefa.drawPrefa();
        _TPrefa.drawPrefaTurned90();
        _TPrefa.drawPrefaTurned180();
        _TPrefa.drawPrefaTurned270();
        _CPrefa = new CPrefa();
        _CPrefa.drawPrefa();
        _CPrefa.drawPrefaTurned90();
        _CPrefa.drawPrefaTurned180();
        _CPrefa.drawPrefaTurned270();
        _SPrefa = new SPrefa();
        _SPrefa.drawPrefa();
        _SPrefa.drawPrefaTurned90();
        _SPrefa.drawPrefaTurned180();
        _SPrefa.drawPrefaTurned270();
        _SquadPrefa = new SquadPrefa();
        _SquadPrefa.drawPrefa();
        _SquadPrefa.drawPrefaTurned90();
        _SquadPrefa.drawPrefaTurned180();
        _SquadPrefa.drawPrefaTurned270();
        _XPrefa = new XPrefa();
        _XPrefa.drawPrefa();
    }
    public ArrayList<Square> renderPrefa(){
        switch (_Count){
            case 1:
                if(_Rotate == 1 || _Rotate == 3){
                    for (Square _Prefa: _LinePrefa._ListaPrefa){
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _LinePrefa._ListaPrefa;
                }
                if(_Rotate == 2 || _Rotate == 4){
                    for (Square _Prefa: _LinePrefa._ListaPrefaTurned){
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _LinePrefa._ListaPrefaTurned;
                }
                break;
            case 2:
                if(_Rotate == 1){
                    for (Square _Prefa: _LPrefa._ListaPrefa) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _LPrefa._ListaPrefa;
                }
                if(_Rotate == 2) {
                    for (Square _Prefa : _LPrefa._ListaPrefaTurned90) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _LPrefa._ListaPrefaTurned90;
                }
                if(_Rotate == 3) {
                    for (Square _Prefa : _LPrefa._ListaPrefaTurned180) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _LPrefa._ListaPrefaTurned180;
                }
                if(_Rotate == 4) {
                    for (Square _Prefa : _LPrefa._ListaPrefaTurned270) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _LPrefa._ListaPrefaTurned270;
                }
                break;
            case 3:
                if(_Rotate == 1){
                    for (Square _Prefa: _TPrefa._ListaPrefa) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _TPrefa._ListaPrefa;
                }
                if(_Rotate == 2) {
                    for (Square _Prefa : _TPrefa._ListaPrefaTurned90) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _TPrefa._ListaPrefaTurned90;
                }
                if(_Rotate == 3) {
                    for (Square _Prefa : _TPrefa._ListaPrefaTurned180) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _TPrefa._ListaPrefaTurned180;
                }
                if(_Rotate == 4) {
                    for (Square _Prefa : _TPrefa._ListaPrefaTurned270) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _TPrefa._ListaPrefaTurned270;
                }
                break;
            case 4:
                if(_Rotate == 1){
                    for (Square _Prefa: _CPrefa._ListaPrefa) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _CPrefa._ListaPrefa;
                }
                if(_Rotate == 2) {
                    for (Square  _Prefa : _CPrefa._ListaPrefaTurned90) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _CPrefa._ListaPrefaTurned90;
                }
                if(_Rotate == 3) {
                    for (Square _Prefa : _CPrefa._ListaPrefaTurned180) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _CPrefa._ListaPrefaTurned180;
                }
                if(_Rotate == 4) {
                    for (Square _Prefa : _CPrefa._ListaPrefaTurned270) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _CPrefa._ListaPrefaTurned270;
                }
                break;
            case 5:
                if(_Rotate == 1){
                    for (Square _Prefa: _SPrefa._ListaPrefa) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SPrefa._ListaPrefa;
                }
                if(_Rotate == 2) {
                    for (Square _Prefa : _SPrefa._ListaPrefaTurned90) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SPrefa._ListaPrefaTurned90;
                }
                if(_Rotate == 3) {
                    for (Square _Prefa : _SPrefa._ListaPrefaTurned180) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SPrefa._ListaPrefaTurned180;
                }
                if(_Rotate == 4) {
                    for (Square _Prefa : _SPrefa._ListaPrefaTurned270) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SPrefa._ListaPrefaTurned270;
                }
                break;
            case 6:
                if(_Rotate == 1){
                    for (Square _Prefa: _SquadPrefa._ListaPrefa) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SquadPrefa._ListaPrefa;
                }
                if(_Rotate == 2) {
                    for (Square _Prefa : _SquadPrefa._ListaPrefaTurned90) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SquadPrefa._ListaPrefaTurned90;
                }
                if(_Rotate == 3) {
                    for (Square _Prefa : _SquadPrefa._ListaPrefaTurned180) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SquadPrefa._ListaPrefaTurned180;
                }
                if(_Rotate == 4) {
                    for (Square _Prefa : _SquadPrefa._ListaPrefaTurned270) {
                        this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                    }
                    return _SquadPrefa._ListaPrefaTurned270;
                }
                break;
            case 7:
                for (Square _Prefa: _XPrefa._ListaPrefa){
                    this._FilledPrefas.rect(_Prefa.get_X(), _Prefa.get_Y(), 30, 30);
                }
                return _XPrefa._ListaPrefa;

            }
        return null;
    }

    //Memento
    public void saveGame(){
        _caretaker.addMemento(new Memento(_Castle1, _Castle2, _PlayerTurn.getText(), _BlueTurn, currentPlayer));
    }

    public void restore(Memento memento){
        _Castle1 = _Fabric.createCharacter(1, memento.get_Castle1().get_X(), memento.get_Castle1().get_Y(), "Characters/Castle.png");
        _Castle2 = _Fabric.createCharacter(1, memento.get_Castle2().get_X(), memento.get_Castle2().get_Y(), "Characters/Castle.png");
        _Castle2.UpDown();
        _Board = new Board();
        _Board.drawBoard();
        _PlayerTurn.setText(memento.get_playerTurn());
        _BlueTurn = memento.get_BlueTurn();
        currentPlayer = memento.get_CurrentPlayer();
        System.out.println(_BlueTurn);
        timer.cancel();
        timer = new Timer();
        startTimer();
    }

    public void trunkInformation(){
        this._Player1Label = new Text(Resources.TIMER_FONT, 600f, 900f, 10,String.valueOf(players[1]));
        this._Player2Label = new Text(Resources.TIMER_FONT, 450f, 900f, 10,String.valueOf(players[0]));;

        this._InfantryLabel = new Text(Resources.TIMER_FONT, 300f, 850f, 20,String.valueOf("Infantry"));
        this._TankLabel = new Text(Resources.TIMER_FONT, 300f, 800f, 20,String.valueOf("Tank"));
        this._ArtilleryLabel = new Text(Resources.TIMER_FONT, 300f, 750f, 20,String.valueOf("Artillery"));

        this._InfantryNumber_Player1 = new Text(Resources.TIMER_FONT, 600f, 850f, 35,String.valueOf(baul.getCantidadInfanteria()));
        this._InfantryNumber_Player2 = new Text(Resources.TIMER_FONT, 450f, 850f, 35,String.valueOf(baul.getCantidadInfanteria()));

        this._TankNumber_Player1 = new Text(Resources.TIMER_FONT, 600f, 800f, 35,String.valueOf(baul.getCantidadTanque()));
        this._TankNumber_Player2 = new Text(Resources.TIMER_FONT, 450f, 800f, 35,String.valueOf(baul.getCantidadTanque()));

        this._Artillery_Player1 = new Text(Resources.TIMER_FONT, 600f, 750f, 35,String.valueOf(baul.getCantidadArquero()));
        this._Artillery_Player2 = new Text(Resources.TIMER_FONT, 450f, 750f, 35,String.valueOf(baul.getCantidadArquero()));
    }
}
