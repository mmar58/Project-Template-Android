import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import com.mmar.mservice;
import com.mmar.tts;
import android.content.ComponentName;
import android.appwidget.AppWidgetManager;
public class mwidget extends AppWidgetProvider
{

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
	{
		// TODO: Implement this method
		try{update(context,appWidgetManager);}catch(Exception e){
		}
	}
	public static void update(Context con,AppWidgetManager appm){
		mservice ms=new mservice(con);
		RemoteViews rview=ms.getlayout(R.layout.dwidget);
		ComponentName cwidget=new ComponentName(con,mwidget.class);
		rview.setTextViewText(R.id.dwidgetText,"this is update");
		appm.updateAppWidget(cwidget,rview);
	}
}