package ru.drugoigorod.app;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ArticlesRecycler extends RecyclerView.Adapter<ArticlesRecycler.ArticlesViewHolder> {

    List<Article> articles;

    ArticlesRecycler(List<Article> articles) {
        this.articles = articles;
    }


    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list, parent, false);
        ArticlesViewHolder avh = new ArticlesViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {

        holder.titleText.setText(articles.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticlesViewHolder extends RecyclerView.ViewHolder {

        TextView titleText;

        public ArticlesViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.title_item);
        }
    }

}
