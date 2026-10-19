package x;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hjlrtqw implements DialogInterface.OnShowListener {
    public final /* synthetic */ kggugdp lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ AlertDialog ojyssqt;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ EditText vivhedu;

    public /* synthetic */ hjlrtqw(AlertDialog alertDialog, EditText editText, String str, kggugdp kggugdpVar) {
        this.nmpwovh = 1;
        this.lthborb = kggugdpVar;
        this.ojyssqt = alertDialog;
        this.vivhedu = editText;
        this.qxvquar = str;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.nmpwovh) {
            case 0:
                kggugdp kggugdpVar = this.lthborb;
                kggugdpVar.getClass();
                AlertDialog alertDialog = this.ojyssqt;
                Button button = alertDialog.getButton(-1);
                button.setTextColor(zamkzqg.pzqxblc(kggugdpVar));
                button.setOnClickListener(new dkpobjg(alertDialog, this.vivhedu, kggugdpVar, (ohwxijw) this.qxvquar));
                break;
            default:
                kggugdp kggugdpVar2 = this.lthborb;
                kggugdpVar2.getClass();
                AlertDialog alertDialog2 = this.ojyssqt;
                alertDialog2.getButton(-1).setOnClickListener(new dkpobjg(alertDialog2, this.vivhedu, (String) this.qxvquar, kggugdpVar2));
                break;
        }
    }

    public /* synthetic */ hjlrtqw(AlertDialog alertDialog, EditText editText, kggugdp kggugdpVar, ohwxijw ohwxijwVar) {
        this.nmpwovh = 0;
        this.lthborb = kggugdpVar;
        this.ojyssqt = alertDialog;
        this.qxvquar = ohwxijwVar;
        this.vivhedu = editText;
    }
}
