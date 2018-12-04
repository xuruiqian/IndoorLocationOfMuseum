package com.minusone.indoorlocationofmuseum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.minusone.indoorlocationofmuseum.activity.R;
import com.minusone.indoorlocationofmuseum.data.StringUrls;
import com.minusone.indoorlocationofmuseum.util.stringcache.TAProcessStringHandler;
import com.minusone.indoorlocationofmuseum.util.stringcache.TAStringCallBackHandler;
import com.ta.TAApplication;
import com.ta.util.cache.TAFileCacheWork;

public class StringAdapter extends AdapterBase {
    private TAFileCacheWork<TextView> taFileCacheWork;
    private Context mContext;

    public StringAdapter(Context context, TAApplication application) {
        taFileCacheWork = new TAFileCacheWork<TextView>();
        taFileCacheWork.setCallBackHandler(new TAStringCallBackHandler());
        taFileCacheWork.setProcessDataHandler(new TAProcessStringHandler());
        taFileCacheWork.setFileCache(application.getFileCache());
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return StringUrls.stringUrls.length;
    }

    @Override
    public Object getItem(int position) {
        return StringUrls.stringUrls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View baseView = inflater.inflate(R.layout.string_cache_item, null);
        final TextView textView = (TextView) baseView.findViewById(R.id.textview);
        taFileCacheWork.loadFormCache(getItem(position), textView);

        return baseView;
    }
}
