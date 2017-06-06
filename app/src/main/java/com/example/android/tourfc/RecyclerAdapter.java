package com.example.android.tourfc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

	private ArrayList<AttractionDetails> mDataset;

	RecyclerAdapter(ArrayList<AttractionDetails> mDataset) {
		this.mDataset = mDataset;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.horizontal_list_item, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		AttractionDetails currentItem = mDataset.get(position);
		holder.mImage.setImageResource(currentItem.getImageResourceId());
		holder.mTitle.setText(currentItem.getTitle());
		holder.mDescription.setText(currentItem.getDescription());
	}

	@Override
	public int getItemCount() {
		return mDataset.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		ImageView mImage;
		TextView mTitle;
		TextView mDescription;

		ViewHolder(View itemView) {
			super(itemView);
			mImage = (ImageView) itemView.findViewById(R.id.attraction_image_view);
			mTitle = (TextView) itemView.findViewById(R.id.attraction_title_text_view);
			mDescription = (TextView) itemView.findViewById(R.id.attraction_brief_desc_text_view);
		}
	}
}
