import android.app.Activity;
import android.os.Bundle;
import java.io.File;
import com.mmar.fm;
import wei.mark.standout.StandOutWindow;
import com.mmar.mActivity;

public class MainActivity extends mActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		StandOutWindow.show(this,swindow.class,9999);
		finish();
    }
}