package co.kr.tjoeun.helloworld.a20200318_04_listview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

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
