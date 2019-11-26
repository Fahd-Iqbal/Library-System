// The following code represents the CoverImage entity class.
package core;

import java.io.InputStream;

public class CoverImage {

    private String mimeType;
    private byte[] imageData;

    public CoverImage() {
        this.mimeType = "";
        this.imageData = null;
    }

    public CoverImage(String mimeType, byte[] imageData) {
        this.mimeType = mimeType;
        this.imageData = imageData;
    }

    public String getMimeType() {
        return mimeType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
