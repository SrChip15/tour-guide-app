package com.example.android.tourfc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class SingleAttractionDataAdapter
		extends RecyclerView.Adapter<SingleAttractionDataAdapter.SingleAttractionViewHolder> {

	private ArrayList<AttractionDetails> mAttractions;
	private Context mContext;

	SingleAttractionDataAdapter(Context context, ArrayList<AttractionDetails> attractions) {
		this.mAttractions = attractions;
		this.mContext = context;
	}

	@Override
	public SingleAttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
		return new SingleAttractionViewHolder(view);
	}

	@Override
	public void onBindViewHolder(SingleAttractionViewHolder holder, int position) {

		AttractionDetails attraction = mAttractions.get(position);

		// Set the image file to be displayed for the attraction
		// Load scaled down version of image file into memory
		holder.mImage
				.setImageBitmap(ScaledImages
						.decodeSampledBitmapFromResource(
								mContext.getResources(),
								attraction.getImageResourceId(),
								200,
								100));

		// Set the title of the attraction
		holder.mAttractionTitle.setText(attraction.getTitle());

		// Set the description of the attraction
		holder.mDescription.setText(attraction.getDescription());
	}

	@Override
	public int getItemCount() {
		return mAttractions.size();
	}

	static class SingleAttractionViewHolder extends RecyclerView.ViewHolder {

		ImageView mImage;

		TextView mAttractionTitle;

		TextView mDescription;

		public SingleAttractionViewHolder(View itemView) {
			super(itemView);

			mImage = (ImageView) itemView.findViewById(R.id.attraction_image_view);

			mAttractionTitle = (TextView) itemView.findViewById(R.id.attraction_title_text_view);

			mDescription = (TextView) itemView.findViewById(R.id.attraction_brief_desc_text_view);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String toastText = "You clicked " + mAttractionTitle.getText().toString();
					Toast.makeText(v.getContext(), toastText, Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}
