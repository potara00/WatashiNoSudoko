package com.example.sadeqnairat.watashinosudoko;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Mohammad Sadeq Nairat on 5/22/2016.
 */
public class SudokuGrid extends GridView {
    private final Context context;
    public SudokuGrid(final Context context, AttributeSet attrs) {

        super(context, attrs);

        this.context = context;

        SudokoGridAdapter sudokoGridAdapter = new SudokoGridAdapter(context);
        setAdapter(sudokoGridAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int x = position % 9;
                int y = position / 9;
                Cell cell =  LevelManager.getInstance().getGrid().getItem(position);
                Cell[][] allCells = LevelManager.getInstance().getGrid().getGrid();
                for(int i = 0 ; i < 9 ; i ++){
                    for(int j = 0 ; j < 9 ; j ++){
                        cell.setBackgroundColor(Color.WHITE);
                        if(allCells[i][j].isSlave()){
                            allCells[i][j].setBackgroundColor(Color.parseColor("#ffd27f"));
                        }
                    }
                }
                if(cell.isSlave())
                     cell.setBackgroundColor(Color.parseColor("#7f5200"));
                LevelManager.getInstance().setSelectedPosition(x,y);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    class SudokoGridAdapter extends BaseAdapter {
        private Context context;

        public SudokoGridAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return 81;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            Cell cell =  LevelManager.getInstance().getGrid().getItem(pos);
            cell.setBackgroundColor(Color.WHITE);
            if (cell.isSlave()){
                cell.setBackgroundColor(Color.parseColor("#ffd27f"));
            }
            return cell;

        }
    }
}
