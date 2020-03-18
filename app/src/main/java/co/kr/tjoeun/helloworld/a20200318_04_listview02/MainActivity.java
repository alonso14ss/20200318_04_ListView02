package co.kr.tjoeun.helloworld.a20200318_04_listview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.kr.tjoeun.helloworld.a20200318_04_listview02.Adapters.RoomAdapter;
import co.kr.tjoeun.helloworld.a20200318_04_listview02.databinding.ActivityMainBinding;
import co.kr.tjoeun.helloworld.a20200318_04_listview02.datas.Room;

public class MainActivity extends BaseActivity {
    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;
    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                클릭된 방의 정보를 목록에서 빼옴 position 번째
                Room clickedRoom = roomDatas.get(position);

//                방 상세 화면으로 이동
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room", clickedRoom);
                startActivity(intent);

            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                꾹 누르고 있으면, 해당 방의 설명을 Toast로 출력

                Room data = roomDatas.get(position);

                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();

                return false; // true : 롱클릭만 실행
            }
        });

    }

    @Override
    public void setValues() {

        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);
        binding.roomListView.setAdapter(roomAdapter);

        addRooms();

    }

    private void addRooms() {
        roomDatas.add(new Room(12000,"서울시 중랑구",2,"중랑구 방"));
        roomDatas.add(new Room(28000,"경기도 고양시",1,"도시 방"));
        roomDatas.add(new Room(4000,"경기도 문산시",-1,"시골 방"));
        roomDatas.add(new Room(18000,"경기도 파주시",0,"애매한 방"));
        roomDatas.add(new Room(8000,"서울시 은평구",21,"살기 좋은 방"));
        roomAdapter.notifyDataSetChanged();

    }


}
