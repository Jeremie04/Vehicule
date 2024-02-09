<<<<< PLUGIN NECESSAIRE
ionic cordova plugin add cordova-plugin-file-transfer
ionic cordova plugin add cordova-plugin-file
PLUGIN NECESSAIRE >>>>>

<<<<<< CODE
import { Component } from '@angular/core';
import { FileTransfer, FileUploadOptions, FileTransferObject } from '@ionic-native/file-transfer/ngx';
import { File } from '@ionic-native/file/ngx';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {
  imageUrls: string[] = [];

  constructor(private transfer: FileTransfer, private file: File) {}

  uploadImages(images: FileList) {
    const fileTransfer: FileTransferObject = this.transfer.create();

    for (let i = 0; i < images.length; i++) {
      const formData = new FormData();
      formData.append('image', images[i]);

      const options: FileUploadOptions = {
        fileKey: 'image',
        fileName: images[i].name,
        chunkedMode: false,
        mimeType: 'image/*',
        params: {key: 'b6b7a7b84eddd705bfa4e3357e418627'}
      };

      fileTransfer.upload(images[i].localURL, 'https://api.imgbb.com/1/upload', options)
        .then((data) => {
          const imageUrl = JSON.parse(data.response).data.url;
          this.imageUrls.push(imageUrl);
        }, (err) => {
          console.error("Erreur lors de l'envoi de l'image : " + JSON.stringify(err));
        });
    }
  }
}
