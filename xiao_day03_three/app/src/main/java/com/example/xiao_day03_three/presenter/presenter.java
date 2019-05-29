package com.example.xiao_day03_three.presenter;

import com.example.xiao_day03_three.User;
import com.example.xiao_day03_three.mode.Imode;
import com.example.xiao_day03_three.mode.mode;
import com.example.xiao_day03_three.view.Iview;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public class presenter implements  Ipresenter {
    Imode imode;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imode=new mode();
    }

    @Override
    public void fuli() {
        imode.fuli(new Callback() {
            @Override
            public void seccued(User user) {
                iview.fuli(user);
            }
        });
    }
}
