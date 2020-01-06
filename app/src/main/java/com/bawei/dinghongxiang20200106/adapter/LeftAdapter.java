package com.bawei.dinghongxiang20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dinghongxiang20200106.R;
import com.bawei.dinghongxiang20200106.entity.LeftEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.VH> {


    private Context context;
    private List<LeftEntity> list;


    public LeftAdapter(Context context, List<LeftEntity> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View inflate = View.inflate(context, R.layout.rev_left, null);

        final VH vh = new VH(inflate);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.name.setText(list.get(position).getCategory().get(position));
        holder.name1.setText(list.get(position).getCategory().get(1));
        holder.name2.setText(list.get(position).getCategory().get(2));
        holder.name3.setText(list.get(position).getCategory().get(3));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revonClick.onClick(list.get(position).getCategory().get(position));

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.name1)
        TextView name1;
        @BindView(R.id.name2)
        TextView name2;
        @BindView(R.id.name3)
        TextView name3;

        public VH(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }


    private RevonClick revonClick;

    public void setRevonClick(RevonClick revonClick) {
        this.revonClick = revonClick;
    }

    public interface RevonClick {
        void onClick(String name);
    }

}
