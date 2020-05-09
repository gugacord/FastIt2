package com.delivery.fastit.Interface;

import android.view.View;

public interface ItemClickListener {
    void OnClick(View view,int position,boolean isLongClick);

    void onClick(View view, int adapterPosition, boolean b);
}
