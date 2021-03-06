package fm.qingting.framework.data;

public class DataParserImpl
  implements IDataParser
{
  private IDataParser nextParser;

  public IDataParser getNextParser()
  {
    return this.nextParser;
  }

  public Result parse(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.nextParser != null)
      return this.nextParser.parse(paramString, paramObject1, paramObject2);
    return null;
  }

  public void setNextParser(IDataParser paramIDataParser)
  {
    this.nextParser = paramIDataParser;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.framework.data.DataParserImpl
 * JD-Core Version:    0.6.2
 */