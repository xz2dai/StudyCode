﻿namespace 植物大战僵尸
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.SettingButton = new System.Windows.Forms.Button();
            this.QuitButton = new System.Windows.Forms.Button();
            this.PlantButton1 = new System.Windows.Forms.Button();
            this.PlantButton2 = new System.Windows.Forms.Button();
            this.SunCountLabel = new System.Windows.Forms.Label();
            this.SunButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(354, 340);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(278, 74);
            this.button1.TabIndex = 0;
            this.button1.Text = "开始";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // SettingButton
            // 
            this.SettingButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.SettingButton.Location = new System.Drawing.Point(971, 8);
            this.SettingButton.Margin = new System.Windows.Forms.Padding(2);
            this.SettingButton.Name = "SettingButton";
            this.SettingButton.Size = new System.Drawing.Size(84, 27);
            this.SettingButton.TabIndex = 1;
            this.SettingButton.Text = "菜单";
            this.SettingButton.UseVisualStyleBackColor = true;
            this.SettingButton.Click += new System.EventHandler(this.SettingButton_Click);
            // 
            // QuitButton
            // 
            this.QuitButton.Location = new System.Drawing.Point(354, 445);
            this.QuitButton.Name = "QuitButton";
            this.QuitButton.Size = new System.Drawing.Size(278, 87);
            this.QuitButton.TabIndex = 2;
            this.QuitButton.Text = "退出";
            this.QuitButton.UseVisualStyleBackColor = true;
            this.QuitButton.Click += new System.EventHandler(this.QuitButton_Click);
            // 
            // PlantButton1
            // 
            this.PlantButton1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.PlantButton1.Location = new System.Drawing.Point(30, 45);
            this.PlantButton1.Margin = new System.Windows.Forms.Padding(2);
            this.PlantButton1.Name = "PlantButton1";
            this.PlantButton1.Size = new System.Drawing.Size(139, 54);
            this.PlantButton1.TabIndex = 3;
            this.PlantButton1.UseVisualStyleBackColor = true;
            this.PlantButton1.Visible = false;
            this.PlantButton1.Click += new System.EventHandler(this.PlantButton1_Click);
            // 
            // PlantButton2
            // 
            this.PlantButton2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.PlantButton2.Location = new System.Drawing.Point(30, 119);
            this.PlantButton2.Margin = new System.Windows.Forms.Padding(2);
            this.PlantButton2.Name = "PlantButton2";
            this.PlantButton2.Size = new System.Drawing.Size(139, 54);
            this.PlantButton2.TabIndex = 4;
            this.PlantButton2.UseVisualStyleBackColor = true;
            this.PlantButton2.Visible = false;
            this.PlantButton2.Click += new System.EventHandler(this.PlantButton2_Click);
            // 
            // SunCountLabel
            // 
            this.SunCountLabel.AutoSize = true;
            this.SunCountLabel.BackColor = System.Drawing.Color.Transparent;
            this.SunCountLabel.Font = new System.Drawing.Font("宋体", 13.875F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.SunCountLabel.Location = new System.Drawing.Point(107, 538);
            this.SunCountLabel.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.SunCountLabel.Name = "SunCountLabel";
            this.SunCountLabel.Size = new System.Drawing.Size(22, 24);
            this.SunCountLabel.TabIndex = 6;
            this.SunCountLabel.Text = "0";
            this.SunCountLabel.Visible = false;
            this.SunCountLabel.TextChanged += new System.EventHandler(this.SunCountLabel_TextChanged);
            // 
            // SunButton
            // 
            this.SunButton.BackColor = System.Drawing.Color.Transparent;
            this.SunButton.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.SunButton.Cursor = System.Windows.Forms.Cursors.Hand;
            this.SunButton.FlatAppearance.BorderSize = 0;
            this.SunButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.SunButton.ForeColor = System.Drawing.Color.Transparent;
            this.SunButton.Image = global::植物大战僵尸.Properties.Resources.frame_0;
            this.SunButton.Location = new System.Drawing.Point(30, 521);
            this.SunButton.Name = "SunButton";
            this.SunButton.Size = new System.Drawing.Size(58, 55);
            this.SunButton.TabIndex = 7;
            this.SunButton.Text = "\r\n";
            this.SunButton.UseVisualStyleBackColor = false;
            this.SunButton.Visible = false;
            this.SunButton.Click += new System.EventHandler(this.SunButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.BackgroundImage = global::植物大战僵尸.Properties.Resources.map;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1057, 587);
            this.ControlBox = false;
            this.Controls.Add(this.SunButton);
            this.Controls.Add(this.SunCountLabel);
            this.Controls.Add(this.PlantButton2);
            this.Controls.Add(this.PlantButton1);
            this.Controls.Add(this.QuitButton);
            this.Controls.Add(this.SettingButton);
            this.Controls.Add(this.button1);
            this.DoubleBuffered = true;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.SizeChanged += new System.EventHandler(this.Form1_SizeChanged);
            this.Click += new System.EventHandler(this.Form1_Click);
            this.Paint += new System.Windows.Forms.PaintEventHandler(this.Form1_Paint);
            this.MouseClick += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseClick);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseMove);
            this.Move += new System.EventHandler(this.Form1_Move);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button SettingButton;
        private System.Windows.Forms.Button QuitButton;
        private System.Windows.Forms.Button PlantButton1;
        private System.Windows.Forms.Button PlantButton2;
        private System.Windows.Forms.Label SunCountLabel;
        private System.Windows.Forms.Button SunButton;
    }
}

