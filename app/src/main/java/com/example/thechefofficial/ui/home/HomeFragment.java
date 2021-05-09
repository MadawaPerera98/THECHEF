package com.example.thechefofficial.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thechefofficial.HomeActivity;
import com.example.thechefofficial.R;
import com.example.thechefofficial.addPost;
import com.example.thechefofficial.data.model.User;
import com.example.thechefofficial.ui.MypostListRecyclerViewAdapter;
import com.example.thechefofficial.ui.slideshow.postViewAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class HomeFragment extends Fragment {


    private FirebaseFirestore firebaseFirestore;


    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser user;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private StorageReference storageReference;
    private List<postModel> postList;
    private RecyclerView recyclerview;
    private postViewAdapter postViewAdapter;
    private TextView emptyList;
    FirebaseFirestore fStore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_home, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        RecyclerView postView =(RecyclerView)root.findViewById(R.id.postList);
        postView.setLayoutManager(new LinearLayoutManager(getContext()));
        fStore = FirebaseFirestore.getInstance();


        String uid = firebaseAuth.getUid();

/*

            Query query = FirebaseDatabase.getInstance().getReference()
                    .child("recipe");


            FirebaseRecyclerOptions<postModel> options =
                    new FirebaseRecyclerOptions.Builder<postModel>()
                            .setQuery(query, postModel.class)
                            .build();
            Log.w("Log ", "date ");
            postViewAdapter = new postViewAdapter(options);
            postView.setAdapter(postViewAdapter);
*/

        return root;


    }

    @Override
    public void onStart() {
        super.onStart();
      //  postViewAdapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
       // postViewAdapter.stopListening();
    }
}