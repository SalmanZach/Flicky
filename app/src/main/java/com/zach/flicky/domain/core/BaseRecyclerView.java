package com.zach.flicky.domain.core;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;



/**
 * Created by Salman Zach on 2/1/19.
 * Email - zach.salmansaifi@gmail.com
 */
public class BaseRecyclerView<T extends Binder> extends RecyclerView.Adapter<BaseRecyclerView.BindingViewHolder> {


    protected List<T> list;

    public BaseRecyclerView(List<T> list) {
        this.list = list;
    }


    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.bind(inflater.inflate(viewType, parent, false));
        return new BindingViewHolder<>(binding);

    }

    @Override
    public void onBindViewHolder(BindingViewHolder bindingViewHolder, int position) {
        final T model = list.get(position);
//        bindingViewHolder.getBinding().setVariable(BR.model, model);
        bindingViewHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getLayoutRes();
    }


    public static class BindingViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private V itemView;

        public BindingViewHolder(V itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }

        public V getBinding() {
            return itemView;
        }
    }

}


