package org.acm.njit.njitacm.SigDisplays;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.acm.njit.njitacm.R;

/**
 * Created by joesc on 12/11/2017.
 */

public class AlgFrag extends Fragment {

    public AlgFrag() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.alg_sig, container, false);
    }
}
