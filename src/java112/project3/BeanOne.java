package java112.project3;

/**
 * This is a JavaBean to demonstrate using beans with JSP.
 *
 * @author eknapp
 */
public class BeanOne {

    private String data;
    private String headTitle;

    /**
     * Gets header title value
     *
     * @return header/title value
     */
    public String getHeadTitle() {
        return headTitle;
    }

    /**
     * Sets header/title value
     *
     * @param headTitle head/title value
     */
    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    /**
     *  Constructor for the BeanOne object
     */
    public BeanOne() {
        data = "default value";
    }

    /**
     *  Gets the Data attribute of the BeanOne object
     *
     *@return    The Data value
     */
    public String getData() {
        return data;
    }

    /**
     *  Sets the Data attribute of the BeanOne object
     *
     *@param  data  The new Data value
     */
    public void setData(String data) {
        this.data = data;
    }
}
