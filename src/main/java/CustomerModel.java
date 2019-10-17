public class CustomerModel {
    public int mCustomerId;
    public String mName, mPin,mPhone;

    public String toString() {
        StringBuilder ss = new StringBuilder( "(" );
        ss.append( mCustomerId ).append( "," );
        ss.append( "\"" ).append( mName ).append( "\"" ).append( "," );
        ss.append( "\"" ).append( mPin).append( "\"" ).append( "," );
        ss.append( mPhone ).append( ")" );
        return ss.toString();
    }
}
