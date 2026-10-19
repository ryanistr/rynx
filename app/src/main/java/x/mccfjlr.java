package x;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: classes.dex */
public final class mccfjlr implements ErrorHandler {
    @Override // org.xml.sax.ErrorHandler
    public final void error(SAXParseException sAXParseException) throws SAXParseException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.ErrorHandler
    public final void fatalError(SAXParseException sAXParseException) throws SAXParseException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.ErrorHandler
    public final void warning(SAXParseException sAXParseException) throws SAXParseException {
        throw sAXParseException;
    }
}
