package x;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Base64;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.R;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class dplrlfq implements yjvhftf {
    public final Object nmpwovh;
    public Object ojyssqt;

    public dplrlfq(FrameLayout frameLayout, ProgressBar progressBar, TextView textView) {
        this.nmpwovh = progressBar;
        this.ojyssqt = textView;
    }

    public byte[] lthborb() throws czgynww {
        try {
            byte[] bArrDecode = Base64.decode((String) this.nmpwovh, 0);
            if (bArrDecode.length == 0 || bArrDecode.length > 65536) {
                throw new czgynww("Authorization response has an invalid size.");
            }
            return bArrDecode;
        } catch (IllegalArgumentException e) {
            throw new czgynww("BROKER_ERROR", 0, "Authorization response is not valid Base64.", e);
        }
    }

    @Override // x.yjvhftf
    public void nmpwovh() {
        ((kggugdp) this.ojyssqt).buswjhz();
    }

    @Override // x.yjvhftf
    public void ojyssqt() {
        kggugdp kggugdpVar = (kggugdp) this.ojyssqt;
        kggugdpVar.getClass();
        try {
            ArrayList arrayListYjvhftf = kggugdpVar.yjvhftf();
            String strLjhdwjr = kggugdpVar.ljhdwjr(arrayListYjvhftf);
            if (!strLjhdwjr.equals((String) this.nmpwovh)) {
                Toast.makeText(kggugdpVar, R.string.scatter_review_changed, 1).show();
                kggugdpVar.cnctlxz();
                return;
            }
            Iterator it = arrayListYjvhftf.iterator();
            boolean zNmpwovh = false;
            while (it.hasNext()) {
                zNmpwovh |= ((araemok) it.next()).nmpwovh.nmpwovh();
            }
            int i = "firmware_upgrade".equals(kggugdpVar.ijakhcl) ? R.string.scatter_firmware_upgrade_confirm_message : R.string.scatter_confirm_message;
            lcgzsis lcgzsisVar = kggugdpVar.wdznaie;
            String string = kggugdpVar.getString(i, lcgzsisVar.vivhedu, lcgzsisVar.qxvquar, Integer.valueOf(arrayListYjvhftf.size()));
            if (!zNmpwovh && !"firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                new AlertDialog.Builder(kggugdpVar).setTitle(R.string.scatter_confirm_title).setMessage(string).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.scatter_execute, new teupdsw(0, strLjhdwjr, kggugdpVar)).show();
                return;
            }
            EditText editText = new EditText(kggugdpVar);
            editText.setSingleLine(true);
            editText.setHint(R.string.scatter_confirm_type_hint);
            editText.setInputType(4097);
            int iDasxvpc = kggugdpVar.dasxvpc(16);
            editText.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
            AlertDialog.Builder title = new AlertDialog.Builder(kggugdpVar).setTitle(R.string.scatter_confirm_title);
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(kggugdpVar.getString("firmware_upgrade".equals(kggugdpVar.ijakhcl) ? R.string.scatter_firmware_upgrade_confirm_critical : R.string.scatter_confirm_critical));
            AlertDialog alertDialogCreate = title.setMessage(sb.toString()).setView(editText).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.scatter_execute, (DialogInterface.OnClickListener) null).create();
            alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText, strLjhdwjr, kggugdpVar));
            alertDialogCreate.show();
        } catch (Throwable th) {
            Toast.makeText(kggugdpVar, String.valueOf(th.getMessage()), 1).show();
        }
    }

    public String vivhedu(byte[] bArr, boolean z) throws CharacterCodingException {
        byte[] bArr2 = (byte[]) this.ojyssqt;
        int length = bArr2.length + bArr.length;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, 0, bArr3, ((byte[]) this.ojyssqt).length, bArr.length);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr3);
        CharBuffer charBufferAllocate = CharBuffer.allocate(length + 8);
        CharsetDecoder charsetDecoder = (CharsetDecoder) this.nmpwovh;
        CoderResult coderResultDecode = charsetDecoder.decode(byteBufferWrap, charBufferAllocate, z);
        if (coderResultDecode.isError()) {
            coderResultDecode.throwException();
        }
        if (coderResultDecode.isOverflow()) {
            throw new IllegalStateException("UTF-8 streaming decoder overflow");
        }
        byte[] bArr4 = new byte[byteBufferWrap.remaining()];
        this.ojyssqt = bArr4;
        byteBufferWrap.get(bArr4);
        if (z) {
            if (((byte[]) this.ojyssqt).length != 0) {
                throw new IllegalStateException("UTF-8 decoder left trailing input");
            }
            CoderResult coderResultFlush = charsetDecoder.flush(charBufferAllocate);
            if (coderResultFlush.isError()) {
                coderResultFlush.throwException();
            }
            if (coderResultFlush.isOverflow()) {
                throw new IllegalStateException("UTF-8 streaming decoder flush overflow");
            }
        }
        charBufferAllocate.flip();
        return charBufferAllocate.toString();
    }

    public dplrlfq() {
        CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        this.nmpwovh = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        this.ojyssqt = new byte[0];
    }

    public dplrlfq(String str, String str2) {
        this.nmpwovh = str.trim();
        this.ojyssqt = zamkzqg.ydsyayx(str2).toLowerCase(Locale.ROOT);
    }

    public dplrlfq(kggugdp kggugdpVar, String str) {
        this.ojyssqt = kggugdpVar;
        this.nmpwovh = str;
    }
}
