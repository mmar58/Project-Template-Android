import wei.mark.standout.StandOutWindow;
import wei.mark.standout.constants.StandOutFlags;
import wei.mark.standout.ui.Window;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.view.View;
import wei.mark.standout.StandOutWindow.*;
public class swindow extends StandOutWindow
{

	@Override
	public String getAppName()
	{
		// TODO: Implement this method
		return "Float app";
	}

	@Override
	public int getAppIcon()
	{
		// TODO: Implement this method
		return R.drawable.icon;
	}

	@Override
	public void createAndAttachView(int id, FrameLayout frame)
	{
		// TODO: Implement this method
		LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
		View view=inflater.inflate(R.layout.swindow,frame,true);
	}

	@Override
	public StandOutWindow.StandOutLayoutParams getParams(int id, Window window)
	{
		// TODO: Implement this method
		return new StandOutLayoutParams(id,150,100,StandOutLayoutParams.CENTER,StandOutLayoutParams.CENTER);
	}



	
}