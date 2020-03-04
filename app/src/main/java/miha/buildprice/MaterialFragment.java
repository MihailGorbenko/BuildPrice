package miha.buildprice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialFragment extends Fragment {

    public MaterialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_material,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.material_recycler);
        String[] titles = {"first","second","third","first","second","third","first","second","third","first","second"};

        RecycleCustomAdapter adapter = new RecycleCustomAdapter(titles);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gm = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gm);

        return view;
    }
}
