package com.example.wow92.dotsandboxes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wow92.dotsandboxes.R;
import com.example.wow92.dotsandboxes.classes.Board;
import com.example.wow92.dotsandboxes.classes.Bot;
import com.example.wow92.dotsandboxes.classes.Box;
import com.example.wow92.dotsandboxes.classes.HorizontalLines;
import com.example.wow92.dotsandboxes.classes.VerticalLines;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Board board;
    ArrayList<Box> boxes = new ArrayList<>();
    ArrayList<HorizontalLines> horizontalLines = new ArrayList<>();
    ArrayList<VerticalLines> verticalLines = new ArrayList<>();
    String linenumber;
    EditText linenumberEnterBox;
    TextView gameOverIndicator;
    TextView blueScore;
    TextView redScore;
    TextView playerToMoveView;
    TextView textView;
    Bot bot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ArrayList<Box> boxes = new ArrayList<>();
        textView = findViewById(R.id.textView);
        gameOverIndicator = findViewById(R.id.gameOverIndicator);
        linenumberEnterBox = findViewById(R.id.fillLineEditText);
        blueScore = findViewById(R.id.blueScoreView);
        redScore = findViewById(R.id.redScoreView);
        playerToMoveView = findViewById(R.id.playerToMoveView);

        gameOverIndicator.setText("False");
        int m = 3;
        int n = 3;
        for (int i =0; i< m*n+n;i++){
            horizontalLines.add(new HorizontalLines("H",i));
        }
        for (int i =0; i< m*n+m;i++){
            verticalLines.add(new VerticalLines("V",i));
        }
        // ADD BOXES TO BOARD
        for (int y=0; y<m; y++ ) {
            for(int x=0; x<n; x++)
            boxes.add(new Box(x,y));
        }
        board=new Board(boxes);
        boxes = board.getBoxes();
        //Assign lines to boxes
        ArrayList<String> lines = new ArrayList<>();
        for (int i=0; i <boxes.size();i++) {
            Box box = boxes.get(i);
            int x = box.getX();
            int y = box.getY();
            HorizontalLines line1 = horizontalLines.get(y*n+x);
            HorizontalLines line2 = horizontalLines.get(y*n+x+n);
            VerticalLines line3 = verticalLines.get(x*m+y);
            VerticalLines line4 = verticalLines.get(x*m+y+m);
            box.addLine(line1);
            box.addLine(line2);
            box.addLine(line3);
            box.addLine(line4);
            lines.add(box.getLines().toString());
            lines.add("\n");
        }
        if (board.getGameOver()){
            gameOverIndicator.setText("True");
        }
        bot = new Bot(board);
        //textView.setText(lines.toString());
        //linenumber = linenumberEnterBox.getText().toString();
        blueScore.setText(board.getBlueScore().toString());
        redScore.setText(board.getRedScore().toString());
        playerToMoveView.setText(board.getPlayer());
    }

    public void seeBoxes(View view){
        //Toast.makeText(MainActivity.this,board.toString(),Toast.LENGTH_LONG).show();
        for (int i = 0 ; i < 12; i++) {
            HorizontalLines theLine = horizontalLines.get(i);
            VerticalLines otherLine = verticalLines.get(i);
            theLine.fillLine();
            otherLine.fillLine();
            board.upDateBoard();
        }
        if (board.checkGameOver()){
            Toast.makeText(this,"game over",Toast.LENGTH_SHORT).show();
        }


    }
    public void fillHori(View view){
        linenumber = linenumberEnterBox.getText().toString();
        Integer lineNumber = Integer.parseInt(linenumber);
        HorizontalLines theLine = horizontalLines.get(lineNumber);
        theLine.fillLine();
        board.upDateBoard();
        if (board.checkGameOver()){
            gameOverIndicator.setText("True");
        }
        blueScore.setText(board.getBlueScore().toString());
        redScore.setText(board.getRedScore().toString());
        playerToMoveView.setText(board.getPlayer());
        textView.setText(textView.getText().toString()+ lineNumber.toString()+"H"+"\n");
        bot.makeAMove();
        blueScore.setText(board.getBlueScore().toString());
        redScore.setText(board.getRedScore().toString());
        playerToMoveView.setText(board.getPlayer());
        textView.setText(textView.getText().toString()+ lineNumber.toString()+"H"+"\n");

    }
    public void fillVerti(View view){
        linenumber = linenumberEnterBox.getText().toString();
        Integer lineNumber = Integer.parseInt(linenumber);
        VerticalLines theLine = verticalLines.get(lineNumber);
        theLine.fillLine();
        board.upDateBoard();
        if (board.checkGameOver()){
            gameOverIndicator.setText("True");
        }
        blueScore.setText(board.getBlueScore().toString());
        redScore.setText(board.getRedScore().toString());
        playerToMoveView.setText(board.getPlayer());
        textView.setText(textView.getText().toString()+ lineNumber.toString()+"V"+"\n");
        bot.makeAMove();
        blueScore.setText(board.getBlueScore().toString());
        redScore.setText(board.getRedScore().toString());
        playerToMoveView.setText(board.getPlayer());
        textView.setText(textView.getText().toString()+ lineNumber.toString()+"V"+"\n");
    }
}
