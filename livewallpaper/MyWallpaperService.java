
import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.content.Context;

public class MyWallpaperService extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        context=this;
        return new MyWallpaperEngine();
    }

    private class MyWallpaperEngine extends Engine {
        private final Handler handler = new Handler();
        private final Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                draw();
            }

        };
        private Paint paint = new Paint();
        private int width;
        int height;
        private boolean visible = true;
        float circleposX=540,circleposY=650;
        boolean goingdown=true;
        public MyWallpaperEngine() {
        
            handler.post(drawRunner);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
            if (visible) {
                handler.post(drawRunner);
            } else {
                handler.removeCallbacks(drawRunner);
            }
        }



	
	@Override
	public void onSurfaceDestroyed(SurfaceHolder holder) {
		super.onSurfaceDestroyed(holder);
		this.visible = false;
		handler.removeCallbacks(drawRunner);
	}

	@Override
	public void onSurfaceChanged(SurfaceHolder holder, int format,
								 int width, int height) {
		this.width = width;
		this.height = height;
		super.onSurfaceChanged(holder, format, width, height);
	}

	@Override
	public void onTouchEvent(MotionEvent event) {

			float x = event.getX();
			float y = event.getY();
			
			super.onTouchEvent(event);
		
	}

	private void draw() {
		SurfaceHolder holder = getSurfaceHolder();
		Canvas canvas = null;
		try {
			canvas = holder.lockCanvas();
			canvas.drawColor(Color.BLACK);
			if (canvas != null) {
				paint.setColor(Color.rgb(20,244,40));
				paint.setTextSize(40);
				canvas.drawRect(290,600,790,1800,paint);
				paint.setColor(Color.rgb(240,55,6));
				//canvas.drawText(count+"",200,200,paint);
				canvas.drawCircle(540,circleposY,50,paint);
				if(circleposY>1745){
					goingdown=false;
				}
				else if(circleposY<655){
					goingdown=true;
				}
				if(goingdown){
					circleposY+=10;
				}else{
					circleposY-=10;
				}
			}
		} finally {
			if (canvas != null)
				holder.unlockCanvasAndPost(canvas);
		}
		handler.removeCallbacks(drawRunner);
		if (visible) {
			handler.postDelayed(drawRunner, 1);
		}
	}

	// Surface view requires that all elements are drawn completely
	
}
}
