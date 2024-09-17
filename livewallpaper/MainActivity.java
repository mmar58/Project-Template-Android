import android.os.Bundle;
import java.io.File;
import com.mmar.fm;
import com.mmar.mActivity;
import android.content.Intent;
import android.view.View;
import android.app.WallpaperManager;
import android.content.ComponentName;


public class MainActivity extends mActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	public void setwallpaper(View v){
		Intent intent = new Intent(
			WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
						new ComponentName(this, MyWallpaperService.class));
        startActivity(intent);
	}
}
