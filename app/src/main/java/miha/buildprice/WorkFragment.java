package miha.buildprice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class WorkFragment extends Fragment {

    public WorkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_work,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.work_recycler);
        String[] titles = {"Ремонт","Площадь","Матвеевка","Бузника 10","second","third","first","second","third","first","second"};

        RecycleCustomAdapter adapter = new RecycleCustomAdapter(titles);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(lm);
        return view;

    }
}
