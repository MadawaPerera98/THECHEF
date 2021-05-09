package com.example.thechefofficial.ui.slideshow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thechefofficial.R;
import com.example.thechefofficial.ui.home.postModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class postViewAdapter  extends FirebaseRecyclerAdapter<postModel,postViewAdapter.postViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public postViewAdapter(@NonNull FirebaseRecyclerOptions<postModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull postViewHolder holder, int position, @NonNull postModel model) {


        holder.recipiname.setText(model.getRecipeName());
        holder.des.setText(model.getRecipeDes());
        holder.userName.setText(model.getUserName());

    }
    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item,parent,false);
        return new postViewHolder(view);
    }

    public class postViewHolder extends RecyclerView.ViewHolder{

        public TextView recipiname;
        public TextView des;
        public TextView userName;
        public ImageView proPic;
        public ImageView recipeImg;
        public Button viewPost;

        public postViewHolder(@NonNull View itemView) {
            super(itemView);
            recipiname = itemView.findViewById(R.id.reciname);
            des = itemView.findViewById(R.id.addrecIDes);
            proPic = itemView.findViewById(R.id.proPic);
            recipeImg = itemView.findViewById(R.id.reciPict);
            userName = itemView.findViewById(R.id.userName);
            viewPost = itemView.findViewById(R.id.viewPostBtn);
        }
    }


}

