package fm.qingting.qtradio.view.search;

import android.content.Context;
import android.view.View.MeasureSpec;
import fm.qingting.framework.view.ButtonViewElement;
import fm.qingting.framework.view.NetImageViewElement;
import fm.qingting.framework.view.QtView;
import fm.qingting.framework.view.TextViewElement;
import fm.qingting.framework.view.ViewElement;
import fm.qingting.framework.view.ViewElement.OnElementClickListener;
import fm.qingting.framework.view.ViewLayout;
import fm.qingting.qtradio.controller.ControllerManager;
import fm.qingting.qtradio.manager.SkinManager;
import fm.qingting.qtradio.model.InfoManager;
import fm.qingting.qtradio.model.RootNode;
import fm.qingting.qtradio.search.SearchItemNode;
import fm.qingting.qtradio.search.SearchNode;
import fm.qingting.qtradio.view.playview.LineElement;
import fm.qingting.qtradio.view.virtualchannels.RatingElement;
import fm.qingting.utils.InputMethodUtil;
import fm.qingting.utils.QTMSGManage;

public class SearchItemShowView extends QtView
{
  private final ViewLayout descLayout = this.itemLayout.createChildLT(480, 50, 208, 52, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout itemLayout = ViewLayout.createViewLayoutWithBoundsLT(720, 170, 720, 1200, 0, 0, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout lineLayout = this.itemLayout.createChildLT(640, 1, 40, 0, ViewLayout.SCALE_FLAG_SLTCW);
  private ButtonViewElement mBg;
  private TextViewElement mInfo;
  private LineElement mLineElement;
  private TextViewElement mName;
  private SearchItemNode mNode;
  private NetImageViewElement mPic;
  private RatingElement mRatingElement;
  private final ViewLayout nameLayout = this.itemLayout.createChildLT(480, 50, 208, 12, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout picLayout = this.itemLayout.createChildLT(136, 136, 40, 17, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout ratingLayout = this.itemLayout.createChildLT(137, 30, 208, 118, ViewLayout.SCALE_FLAG_SLTCW);

  public SearchItemShowView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mBg = new ButtonViewElement(paramContext);
    this.mBg.setBackgroundColor(SkinManager.getItemHighlightMaskColor(), SkinManager.getCardColor());
    addElement(this.mBg);
    this.mBg.setOnElementClickListener(new ViewElement.OnElementClickListener()
    {
      public void onElementClick(ViewElement paramAnonymousViewElement)
      {
        if (InfoManager.getInstance().root().mSearchNode.getVoiceSearch())
        {
          InfoManager.getInstance().root().mSearchNode.setVoiceSearch(false);
          QTMSGManage.getInstance().sendStatistcsMessage("VoiceRecognition", "voice_search_click");
        }
        InputMethodUtil.hideSoftInput(SearchItemShowView.this);
        ControllerManager.getInstance().redirectToViewBySearchNode(SearchItemShowView.this.mNode);
      }
    });
    this.mPic = new NetImageViewElement(paramContext);
    this.mPic.setDefaultImageRes(2130837925);
    this.mPic.setBoundColor(SkinManager.getDividerColor());
    addElement(this.mPic, paramInt);
    this.mName = new TextViewElement(paramContext);
    this.mName.setMaxLineLimit(1);
    this.mName.setColor(SkinManager.getTextColorNormal());
    addElement(this.mName);
    this.mInfo = new TextViewElement(paramContext);
    this.mInfo.setMaxLineLimit(1);
    this.mInfo.setColor(SkinManager.getTextColorSubInfo());
    addElement(this.mInfo);
    this.mRatingElement = new RatingElement(paramContext);
    addElement(this.mRatingElement, paramInt);
    this.mLineElement = new LineElement(paramContext);
    this.mLineElement.setColor(SkinManager.getDividerColor());
    this.mLineElement.setOrientation(1);
    addElement(this.mLineElement);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.itemLayout.scaleToBounds(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    this.ratingLayout.scaleToBounds(this.itemLayout);
    this.picLayout.scaleToBounds(this.itemLayout);
    this.nameLayout.scaleToBounds(this.itemLayout);
    this.descLayout.scaleToBounds(this.itemLayout);
    this.lineLayout.scaleToBounds(this.itemLayout);
    this.mBg.measure(this.itemLayout);
    this.mPic.measure(this.picLayout);
    this.mPic.setBoundLineWidth(this.lineLayout.height);
    this.mName.measure(this.nameLayout);
    this.mInfo.measure(this.descLayout);
    this.mRatingElement.measure(this.ratingLayout);
    this.mLineElement.measure(this.lineLayout.leftMargin, this.itemLayout.height - this.lineLayout.height, this.lineLayout.getRight(), this.itemLayout.height);
    this.mName.setTextSize(SkinManager.getInstance().getNormalTextSize());
    this.mInfo.setTextSize(SkinManager.getInstance().getMiddleTextSize());
    setMeasuredDimension(this.itemLayout.width, this.itemLayout.height);
  }

  public void update(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("content"))
    {
      this.mNode = ((SearchItemNode)paramObject);
      this.mPic.setImageUrl(this.mNode.cover);
      this.mName.setText(this.mNode.name);
      this.mRatingElement.setRating(this.mNode.star);
      this.mInfo.setText(this.mNode.desc);
    }
    while (!paramString.equalsIgnoreCase("nbl"))
      return;
    boolean bool = ((Boolean)paramObject).booleanValue();
    LineElement localLineElement = this.mLineElement;
    if (bool);
    for (int i = 0; ; i = 4)
    {
      localLineElement.setVisible(i);
      return;
    }
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.search.SearchItemShowView
 * JD-Core Version:    0.6.2
 */