import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatTabsModule} from '@angular/material/tabs';

@NgModule({
    imports: [MatButtonModule, CommonModule, MatToolbarModule,MatFormFieldModule,MatInputModule,MatCardModule,MatTabsModule,MatIconModule],
    exports: [MatButtonModule, CommonModule, MatToolbarModule,MatFormFieldModule,MatInputModule,MatCardModule,MatTabsModule,MatIconModule],
  })
  export class MaterialModule { }